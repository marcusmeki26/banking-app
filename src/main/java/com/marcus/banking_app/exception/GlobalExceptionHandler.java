package com.marcus.banking_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice 
@Slf4j 
public class GlobalExceptionHandler {
  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<ErrorMessage> handleConflictException(ConflictException ex){
    log.warn("Unable to create new user: {}", ex.getMessage());
    return new ResponseEntity<>(new ErrorMessage(ex.getCode(), ex.getMessage()), HttpStatus.CONFLICT);
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> handleInvalidValueException(MethodArgumentNotValidException ex){
    log.warn("Unable to process invalid/missing values: {}", ex.getMessage());
    return new ResponseEntity<>(new ErrorMessage("INVALID_VALUE", ex.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.UNPROCESSABLE_CONTENT);
  }
  
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex){
    log.warn("Unable to process account does not exist: {}", ex.getMessage());
    return new ResponseEntity<>(new ErrorMessage(ex.getCode(), ex.getMessage()), HttpStatus.UNPROCESSABLE_CONTENT);
  }
  
  @ExceptionHandler(InvalidValueException.class)
  public ResponseEntity<ErrorMessage> handleInvalidValueException(InvalidValueException ex){
    log.warn("Unable to process invalid/missing values: {}", ex.getMessage());
    return new ResponseEntity<>(new ErrorMessage(ex.getCode(), ex.getMessage()), HttpStatus.UNPROCESSABLE_CONTENT);
  }
}
