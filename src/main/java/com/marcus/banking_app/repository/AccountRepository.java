package com.marcus.banking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcus.banking_app.entity.Accounts;

@Repository 
public interface AccountRepository extends JpaRepository<Accounts, Long> {
  Accounts findByAccountNumber(String accountNumber);
}
