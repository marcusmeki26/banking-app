package com.marcus.banking_app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcus.banking_app.dto.AccountRequest;
import com.marcus.banking_app.dto.AccountResponse;
import com.marcus.banking_app.services.AccountService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController 
@AllArgsConstructor 
@RequestMapping ("/v1/account") 
public class AccountController {
  private AccountService accountService;

  @PostMapping 
  public ResponseEntity<AccountResponse> postAccount(
    @Valid @RequestBody AccountRequest accountRequest
  ){
    return ResponseEntity.ok().body(accountService.postAccount(accountRequest));
  }
}
