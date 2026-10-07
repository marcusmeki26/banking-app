package com.marcus.banking_app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcus.banking_app.dto.AccountRequest;
import com.marcus.banking_app.dto.AccountResponse;
import com.marcus.banking_app.dto.DepositRequest;
import com.marcus.banking_app.dto.DepositResponse;
import com.marcus.banking_app.dto.TransferRequest;
import com.marcus.banking_app.dto.TransferResponse;
import com.marcus.banking_app.dto.WithdrawRequest;
import com.marcus.banking_app.dto.WithdrawResponse;
import com.marcus.banking_app.services.AccountService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController 
@AllArgsConstructor 
@RequestMapping ("/v1/account") 
public class AccountController {
  private AccountService accountService;

  @GetMapping 
  public ResponseEntity<List<AccountResponse>> getAllAccounts(){
    return ResponseEntity.ok().body(accountService.getAllAccounts());
  }

  @GetMapping("/{accountNumber}")
  public ResponseEntity<AccountResponse> getBalance(
    @PathVariable String accountNumber
  ){
    return ResponseEntity.ok().body(accountService.getBalance(accountNumber));
  }

  @PostMapping 
  public ResponseEntity<AccountResponse> postAccount(
    @Valid @RequestBody AccountRequest accountRequest
  ){
    return ResponseEntity.ok().body(accountService.postAccount(accountRequest));
  }

  @PostMapping("/deposit") 
  public ResponseEntity<DepositResponse> deposit(
    @Valid @RequestBody DepositRequest depositRequest
  ){
    return ResponseEntity.ok().body(accountService.deposit(depositRequest));
  }

  @PostMapping("/withdraw")
  public ResponseEntity<WithdrawResponse> deposit(
    @Valid @RequestBody WithdrawRequest withdrawRequest
  ){
    return ResponseEntity.ok().body(accountService.withdraw(withdrawRequest));
  }

  @PostMapping("/transfer")
  public ResponseEntity<TransferResponse> transfer(
    @Valid @RequestBody TransferRequest transferRequest
  ){
    return ResponseEntity.ok().body(accountService.transfer(transferRequest));
  }
}
