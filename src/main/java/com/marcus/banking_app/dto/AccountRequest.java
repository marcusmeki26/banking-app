package com.marcus.banking_app.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter 
public class AccountRequest {
  @NotEmpty (message = "Account number is required")
  private String accountNumber;
  @NotEmpty (message = "Account Holder Name is required")
  private String accountHolderName;
  @NotNull (message = "Deposit is required")
  @Min (value = 0, message = "Deposit should be greater than or equal to zero")
  private Float deposit;
}
