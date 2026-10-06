package com.marcus.banking_app.services;

import org.springframework.stereotype.Service;

import com.marcus.banking_app.dto.AccountRequest;
import com.marcus.banking_app.dto.AccountResponse;
import com.marcus.banking_app.entity.Accounts;
import com.marcus.banking_app.exception.ConflictException;
import com.marcus.banking_app.mapper.AccountMapper;
import com.marcus.banking_app.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class AccountService {
  private final AccountRepository accountRepository;
  private final AccountMapper accountMapper;

  /**
   * If the account is valid. Insert it to {@code Account} entity
   * @param accountRequest an object of {@code AccountRequest}
   * @return an object of {@code AccountResponse}
   */
  public AccountResponse postAccount(AccountRequest accountRequest){
    Accounts account = new Accounts();

    if(getAccountByAccountNumber(accountRequest.getAccountNumber()))
      throw new ConflictException("ACCOUNT_NUMBER_EXIST", "Account number already exist.");

    account.setAccountNumber(accountRequest.getAccountNumber());
    account.setAccountName(accountRequest.getAccountHolderName());

    // Create another exception handler about less than or equal to 0 balance :REMOVE-COMMENT
    // Or we can use exception throw by @Valid to create a meaningful error message :REMOVE-COMMENT
    account.setBalance(accountRequest.getDeposit());

    return accountMapper.toReponse(accountRepository.save(account));
  }

  public Boolean getAccountByAccountNumber(String accountNumber){
    if(accountRepository.findByAccountNumber(accountNumber) == null)
      return false;

    return true;
  }
}
