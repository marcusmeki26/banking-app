package com.marcus.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcus.banking_app.entity.Transactions;
import com.marcus.banking_app.record.TransactionsIdOnly;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
  TransactionsIdOnly findTopProjectedByOrderByIdDesc();
}
