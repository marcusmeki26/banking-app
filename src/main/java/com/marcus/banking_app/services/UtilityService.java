package com.marcus.banking_app.services;

import org.springframework.stereotype.Service;

import com.marcus.banking_app.entity.Accounts;
import com.marcus.banking_app.exception.ResourceNotFoundException;
import com.marcus.banking_app.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class UtilityService {
  private final AccountRepository accountRepository;

  /**
   * Gets a record of {@code Accounts} entity
   * @param accountNumber the value of account number to fetch
   * @return an object of {@code Accounts} entity
   */
  public Accounts getAccountByAccountNumber(String accountNumber){
    Accounts account = accountRepository.findByAccountNumber(accountNumber);

    if(account == null)
      throw new ResourceNotFoundException("ACCOUNT_NUMBER_NOT_EXISTING", "No existing user found");

    return account;
  }
}
