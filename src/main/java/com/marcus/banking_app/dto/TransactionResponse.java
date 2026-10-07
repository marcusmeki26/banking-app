package com.marcus.banking_app.dto;

import java.time.LocalDateTime;

import com.marcus.banking_app.enums.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class TransactionResponse {
  private String transactionReference;
  private TransactionType transactionType;
  private Float amount;
  private LocalDateTime transactionDate;
  private String referenceAccount;
  private Float balance;
}
