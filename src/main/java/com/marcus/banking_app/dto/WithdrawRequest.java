package com.marcus.banking_app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class WithdrawRequest {
  @NotEmpty(message = "Account Number is required")
  private String accountNumber;
  @Min(value = 1, message = "Withdraw should be greater than zero")
  private Float withdrawAmount;
}
