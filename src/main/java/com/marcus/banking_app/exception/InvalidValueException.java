package com.marcus.banking_app.exception;

import lombok.Getter;

@Getter 
public class InvalidValueException extends RuntimeException{
  private String code;

  public InvalidValueException(String code, String message){
    super(message);
    this.code = code;
  }
}
