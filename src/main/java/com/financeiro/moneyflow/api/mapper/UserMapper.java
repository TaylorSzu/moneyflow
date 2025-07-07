package com.financeiro.moneyflow.api.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.financeiro.moneyflow.api.dto.UpdateUserDTO;
import com.financeiro.moneyflow.api.dto.UserDTO;
import com.financeiro.moneyflow.core.domain.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
    User toUser(UpdateUserDTO updateUserDTO);
    List<UserDTO> toUserDTOList(List<User> users);
}