package com.marcus.banking_app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.marcus.banking_app.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
public class Transactions {
  @Id 
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer id;

  private String transactionReference;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_number", referencedColumnName = "accountNumber")
  private Accounts account;
  
  @Enumerated(EnumType.STRING)
  private TransactionType transactionType;

  private Float amount;

  private Float balance;

  private String referenceAccount;

  @CreationTimestamp 
  private LocalDateTime createdAt;
}
