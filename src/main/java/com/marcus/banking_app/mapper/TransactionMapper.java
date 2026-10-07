package com.marcus.banking_app.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.marcus.banking_app.dto.TransactionResponse;
import com.marcus.banking_app.entity.Transactions;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
  @Mapping(source = "createdAt", target = "transactionDate")
  TransactionResponse toResponse(Transactions transaction);
  List<TransactionResponse> toResponseList(List<Transactions> transactions);
}
