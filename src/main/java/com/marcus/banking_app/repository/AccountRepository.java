package com.marcus.banking_app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.marcus.banking_app.entity.Accounts;

@Repository 
public interface AccountRepository extends JpaRepository<Accounts, Long> {
  @Query("SELECT acc FROM Accounts acc WHERE acc.isDeleted = false")
  List<Accounts> findActiveAccounts(Boolean isDeleted);
  Accounts findByAccountNumber(String accountNumber);
}
