package com.marcus.banking_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class GlobalExceptionHandler {
  @ExceptionHandler(ConflictException.class)
  public ResponseEntity<ErrorMessage> handleConflictException(ConflictException ex){
    return new ResponseEntity<>(new ErrorMessage(ex.getCode(), ex.getMessage()), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorMessage> handleInvalidValueException(MethodArgumentNotValidException ex){
    return new ResponseEntity<>(new ErrorMessage("INVALID_VALUE", ex.getBindingResult().getFieldError().getDefaultMessage()), HttpStatus.UNPROCESSABLE_CONTENT);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex){
    return new ResponseEntity<>(new ErrorMessage(ex.getCode(), ex.getMessage()), HttpStatus.UNPROCESSABLE_CONTENT);
  }
}
