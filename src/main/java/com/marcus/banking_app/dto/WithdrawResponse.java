package com.marcus.banking_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class WithdrawResponse {
  private Float previousBalance;
  private Float withdrawAmount;
  private Float newBalance;
}
