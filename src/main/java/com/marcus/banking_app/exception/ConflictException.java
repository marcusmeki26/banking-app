package com.marcus.banking_app.exception;

import lombok.Getter;

@Getter 
public class ConflictException extends RuntimeException{
  private String code;

  public ConflictException(String code, String message){
    super(message);
    this.code = code;
  }
}
