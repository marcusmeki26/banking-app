package com.marcus.banking_app.services;

import org.springframework.stereotype.Service;

import com.marcus.banking_app.dto.DepositRequest;
import com.marcus.banking_app.entity.Accounts;
import com.marcus.banking_app.entity.Transactions;
import com.marcus.banking_app.enums.TransactionType;
import com.marcus.banking_app.record.TransactionsIdOnly;
import com.marcus.banking_app.repository.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class TransactionService {
  private final TransactionRepository transactionRepository;

  public void InsertTransactionDeposit(Accounts account, DepositRequest depositRequest){
    Transactions transaction = new Transactions();

    String transactionRef = String.format("TXN-%03d", getNextTransactionReference());
    transaction.setTransactionReference(transactionRef);
    transaction.setAccount(account);
    transaction.setTransactionType(TransactionType.DEPOSIT);
    transaction.setAmount(depositRequest.getDeposit());
    transaction.setBalanace(depositRequest.getDeposit() + account.getBalance());
    transactionRepository.save(transaction);
  }

  public Integer getNextTransactionReference(){
    TransactionsIdOnly transaction = transactionRepository.findTopProjectedByOrderByIdDesc();
  
    return (transaction == null) ? 1 : transaction.id();  
  }
}
