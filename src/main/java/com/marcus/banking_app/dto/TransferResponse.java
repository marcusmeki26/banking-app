package com.marcus.banking_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class TransferResponse {
  private String sourceAccountNumber;
  private String destinationAccountNumber;
  private Float transferAmount;
}
