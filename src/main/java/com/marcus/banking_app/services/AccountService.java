package com.marcus.banking_app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marcus.banking_app.dto.AccountRequest;
import com.marcus.banking_app.dto.AccountResponse;
import com.marcus.banking_app.dto.DepositRequest;
import com.marcus.banking_app.dto.DepositResponse;
import com.marcus.banking_app.dto.WithdrawRequest;
import com.marcus.banking_app.dto.WithdrawResponse;
import com.marcus.banking_app.entity.Accounts;
import com.marcus.banking_app.exception.ConflictException;
import com.marcus.banking_app.exception.InvalidValueException;
import com.marcus.banking_app.exception.ResourceNotFoundException;
import com.marcus.banking_app.mapper.AccountMapper;
import com.marcus.banking_app.repository.AccountRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AccountService {
  private final AccountRepository accountRepository;
  private final AccountMapper accountMapper;
  private final TransactionService transactionService;

  /**
   * Fetches all record from {@code Accounts} entity
   * @return returns a {@code List} of {@code AccountResponse}
   */
  public List<AccountResponse> getAllAccounts(){
    return accountMapper.toResponseList(accountRepository.findAll());
  }

  /**
   * Retrieves the balance of the specied account number
   * @param accountNumber the value of account number to search
   * @return an object of {@code AccountResponse}
   */
  public AccountResponse getBalance(String accountNumber){
    return accountMapper.toReponse(getAccountByAccountNumber(accountNumber));
  }

  /**
   * If the account is valid. Insert it to {@code Account} entity
   * @param accountRequest an object of {@code AccountRequest}
   * @return an object of {@code AccountResponse}
   */
  public AccountResponse postAccount(AccountRequest accountRequest){
    Accounts account = new Accounts();

    if(getIfAccountNumberExist(accountRequest.getAccountNumber()))
      throw new ConflictException("ACCOUNT_NUMBER_EXIST", "Account number already exist.");
    
    account.setAccountNumber(accountRequest.getAccountNumber());
    account.setAccountName(accountRequest.getAccountHolderName());
    account.setBalance(accountRequest.getDeposit());
    return accountMapper.toReponse(accountRepository.save(account));
  }

  /**
   * Performs deposit based on the specified account number
   * @param depositRequest an object of {@code DepositRequest}
   * @return an object of {@code DepositResponse}
   */
  @Transactional 
  public DepositResponse deposit(DepositRequest depositRequest){
    Accounts account = getAccountByAccountNumber(depositRequest.getAccountNumber());
    DepositResponse depositResponse = new DepositResponse();

    transactionService.InsertTransactionDeposit(account, depositRequest);

    depositResponse.setPreviousBalance(account.getBalance());
    depositResponse.setDepositAmount(depositRequest.getDeposit());

    Float newBalance = depositRequest.getDeposit() + account.getBalance();
    account.setBalance(newBalance);
    accountRepository.save(account);

    depositResponse.setNewBalance(account.getBalance());

    return depositResponse;
  }

  @Transactional 
  public WithdrawResponse withdraw(WithdrawRequest withdrawRequest){
    Accounts account = getAccountByAccountNumber(withdrawRequest.getAccountNumber());
    WithdrawResponse withdrawResponse = new WithdrawResponse();

    if(withdrawRequest.getWithdrawAmount() > account.getBalance())
      throw new InvalidValueException("INVALID_VALUE", "Withdraw amount is greater than balance");

    transactionService.InsertTransactionWithdraw(account, withdrawRequest);

    withdrawResponse.setPreviousBalance(account.getBalance());
    withdrawResponse.setPreviousBalance(withdrawRequest.getWithdrawAmount());

    Float newBalance = account.getBalance() - withdrawRequest.getWithdrawAmount();
    account.setBalance(newBalance);
    accountRepository.save(account);

    withdrawResponse.setNewBalance(newBalance);

    return withdrawResponse;
  }

  // ========================================================
  // Utilities
  // ========================================================
  /**
   * Gets a record of {@code Accounts} entity
   * @param accountNumber the value of account number to fetch
   * @return an object of {@code Accounts} entity
   */
  public Accounts getAccountByAccountNumber(String accountNumber){
    Accounts account = accountRepository.findByAccountNumber(accountNumber);

    if(account == null)
      throw new ResourceNotFoundException("ACCOUNT_NUMBER_NOT_EXISTING", "No existing user found");

    return account;
  }

  /**
   * Checks if account number exists
   * @param accountNumber the value of account number to check
   * @return {@code true} if account number exist
   */
  public Boolean getIfAccountNumberExist(String accountNumber){
    if(accountRepository.findByAccountNumber(accountNumber) == null)
      return false;

    return true;
  }
}
