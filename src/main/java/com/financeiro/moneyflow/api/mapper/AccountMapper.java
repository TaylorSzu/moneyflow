package com.financeiro.moneyflow.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.financeiro.moneyflow.api.dto.AccountDTO;
import com.financeiro.moneyflow.api.dto.CreateAccountDTO;
import com.financeiro.moneyflow.api.dto.UpdateAccountDTO;
import com.financeiro.moneyflow.core.domain.Account;
import com.financeiro.moneyflow.core.domain.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    @Mapping(source = "createAccountDTO.name", target = "name")
    @Mapping(source = "user", target = "user") 
    @Mapping(target = "id", ignore = true)
    Account toAccount(CreateAccountDTO createAccountDTO, User user);

    @Mapping(source = "user.id", target = "userId")
    CreateAccountDTO toCreateAccountDTO(Account account);

    @Mapping(target = "user", ignore = true)
    Account toAccount(UpdateAccountDTO updateAccountDTO);

    @Mapping(source = "user.id", target = "userId")
    AccountDTO toAccountDTO(Account account);
    List<AccountDTO> toAccountDTOList(List<Account> accounts);
}
