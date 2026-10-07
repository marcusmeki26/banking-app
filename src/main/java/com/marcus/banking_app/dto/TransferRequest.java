package com.marcus.banking_app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class TransferRequest {
  @NotEmpty(message = "source account number is required")
  private String sourceAccountNumber;
  @NotEmpty(message = "destination account number is required")
  private String destinationAccountNumber;
  @Min(value = 1, message = "transfer amount should be greater than zero")
  private Float transferAmount;
}
