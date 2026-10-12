package com.marcus.banking_app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter 
public class AccountPatchRequest {
  @NotBlank(message = "account name is required")
  private String accountName;
}
