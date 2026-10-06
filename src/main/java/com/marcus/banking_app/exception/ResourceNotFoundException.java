package com.marcus.banking_app.exception;

import lombok.Getter;

@Getter 
public class ResourceNotFoundException extends RuntimeException {
  private String code;

  public ResourceNotFoundException(String code, String message){
    super(message);
    this.code = code;
  }
}
