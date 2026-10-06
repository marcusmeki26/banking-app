package com.marcus.banking_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class DepositResponse {
  private Float previousBalance;
  private Float depositAmount;
  private Float newBalance;
}
