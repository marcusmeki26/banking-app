package com.marcus.banking_app.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.marcus.banking_app.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
public class Transactions {
  @Id 
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer id;

  // private String transactionReference;

  // private String accountNumber; JOIN? :REMOVE-COMMENT
  
  private TransactionType transactionType;

  private Float amount;

  private Float balanace;

  // private String referenceAccount;

  @CreationTimestamp 
  private LocalDateTime createdAt;
}
