package com.marcus.banking_app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marcus.banking_app.dto.DepositRequest;
import com.marcus.banking_app.dto.TransactionResponse;
import com.marcus.banking_app.dto.TransferRequest;
import com.marcus.banking_app.dto.WithdrawRequest;
import com.marcus.banking_app.entity.Accounts;
import com.marcus.banking_app.entity.Transactions;
import com.marcus.banking_app.enums.TransactionType;
import com.marcus.banking_app.mapper.TransactionMapper;
import com.marcus.banking_app.record.TransactionsIdOnly;
import com.marcus.banking_app.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor 
@Slf4j 
public class TransactionService {
  private final TransactionRepository transactionRepository;
  private final TransactionMapper transactionMapper;
  private final UtilityService utilityService;

  public List<TransactionResponse> getTransactionsByAccountNumber(String accountNumber){
    Accounts account = utilityService.getAccountByAccountNumber(accountNumber);

    return transactionMapper.toResponseList(transactionRepository.findByAccount_accountNumber(account.getAccountNumber()));
  }

  /**
   * Inserts a deposit transaction to {@code Transactions} entity
   * @param account an object of {@code Accounts} that performs the action
   * @param depositRequest an object of {@code DepositRequest} 
   */
  public void insertTransactionDeposit(Accounts account, DepositRequest depositRequest){
    Transactions transaction = new Transactions();

    String transactionRef = String.format("TXN-%03d", getNextTransactionReference());
    transaction.setTransactionReference(transactionRef);
    transaction.setAccount(account);
    transaction.setTransactionType(TransactionType.DEPOSIT);
    transaction.setAmount(depositRequest.getDeposit());
    transaction.setBalance(depositRequest.getDeposit() + account.getBalance());
    transactionRepository.save(transaction);
    log.info("Inserted a deposit transaction for account {} with an amount of {}", account.getAccountNumber(), depositRequest.getDeposit());
  }

  /**
   * Inserts a withdraw transaction to {@code Transactions} entity
   * @param account an object of {@code Accounts} that performs the action
   * @param withdrawRequest an object of {@code WithdrawRequest}
   */
  public void insertTransactionWithdraw(Accounts account, WithdrawRequest withdrawRequest){
    Transactions transaction = new Transactions();

    String transactionRef = String.format("TXN-%03d", getNextTransactionReference());
    transaction.setTransactionReference(transactionRef);
    transaction.setAccount(account);
    transaction.setTransactionType(TransactionType.WITHDRAW);
    transaction.setAmount(withdrawRequest.getWithdrawAmount());
    transaction.setBalance(account.getBalance() - withdrawRequest.getWithdrawAmount());
    transactionRepository.save(transaction);
    log.info("Inserted a withdrawal transaction for account {} with an amount of {}", account.getAccountNumber(), withdrawRequest.getWithdrawAmount());
  }

  /**
   * Inserts a transfer transction to {@code Transactions} entity
   * @param sourceAccount an object of {@code Accounts} entity which is the source of funds
   * @param destinationAccount an object of {@code Accounts} entity which is the destination of funds
   * @param transferRequest an object of {@code TransferRequest}
   */
  public void insertTransactionTransfer(Accounts sourceAccount, Accounts destinationAccount, TransferRequest transferRequest){
    Transactions transaction = new Transactions();

    String transactionRef = String.format("TXN-%03d", getNextTransactionReference());
    transaction.setTransactionReference(transactionRef);
    transaction.setAccount(sourceAccount);
    transaction.setTransactionType(TransactionType.TRANSFER);
    transaction.setAmount(transferRequest.getTransferAmount());
    transaction.setBalance(sourceAccount.getBalance() - transferRequest.getTransferAmount());
    transaction.setReferenceAccount(destinationAccount.getAccountNumber());
    transactionRepository.save(transaction);

    log.info("Inserted a transacter transaction from account {} to account {} with an amount of {}", sourceAccount.getAccountNumber(), destinationAccount.getAccountNumber(), transferRequest.getTransferAmount());
  }

  /**
   * Gets the last record from {@code Transactions} entity
   * @return the last id from {@code Transactions} entity, if empty returns 1
   */
  private Integer getNextTransactionReference(){
    TransactionsIdOnly transaction = transactionRepository.findTopProjectedByOrderByIdDesc();
  
    return (transaction == null) ? 1 : transaction.id() + 1;  
  }
}
