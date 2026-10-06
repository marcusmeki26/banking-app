package com.marcus.banking_app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.marcus.banking_app.dto.AccountResponse;
import com.marcus.banking_app.entity.Accounts;

@Mapper(componentModel = "spring")
public interface AccountMapper {
  @Mapping(source = "accountName", target = "accountHolderName")
  AccountResponse toReponse(Accounts account);
  List<AccountResponse> toResponseList(List<Accounts> accounts);
}
