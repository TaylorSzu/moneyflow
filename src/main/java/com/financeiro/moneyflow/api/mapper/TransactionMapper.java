package com.financeiro.moneyflow.api.mapper;

import com.financeiro.moneyflow.api.dto.TransactionDTO;
import com.financeiro.moneyflow.api.dto.UpdateTransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.financeiro.moneyflow.api.dto.CreateTransactionDTO;
import com.financeiro.moneyflow.core.domain.Account;
import com.financeiro.moneyflow.core.domain.Transaction;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    @Mapping(target = "account", source = "account")
    @Mapping(target = "id", ignore = true)
    Transaction toTransaction(CreateTransactionDTO dto, Account account);

    @Mapping(source = "account.id", target = "accountId")
    CreateTransactionDTO toCreateTransactionDTO(Transaction transaction);

    @Mapping(source = "account", target = "account")
    @Mapping(source = "updateTransactionDTO.id", target = "id")
    Transaction toTransaction(UpdateTransactionDTO updateTransactionDTO, Account account);

    @Mapping(source = "account.id", target = "accountId")
    TransactionDTO toTransactionDTO(Transaction transaction);
    List<TransactionDTO> toTransactionDTOList(List<Transaction> transactions);
}
