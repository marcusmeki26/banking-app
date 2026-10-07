package com.marcus.banking_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marcus.banking_app.dto.TransactionResponse;
import com.marcus.banking_app.services.TransactionService;

import lombok.AllArgsConstructor;

@RestController 
@AllArgsConstructor 
@RequestMapping("/v1/transaction")
public class TransactionController {
  private TransactionService transactionService;

  @GetMapping 
  public ResponseEntity<List<TransactionResponse>> getTransactionByAccountNumber(
    @RequestParam (name = "accountNumber", required = true) String accountNumber
  ){
    return ResponseEntity.ok().body(transactionService.getTransactionsByAccountNumber(accountNumber));
  }
}
