package com.marcus.banking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcus.banking_app.entity.Transactions;
import com.marcus.banking_app.record.TransactionsIdOnly;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
  TransactionsIdOnly findTopProjectedByOrderByIdDesc();
  List<Transactions> findByAccount_accountNumber(String accountNumber);
}
