package com.marcus.banking_app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class AccountResponse {
  private String accountNumber;
  private String accountHolderName;
  private Float deposit;
}
