package com.financeiro.moneyflow.api.dto;

public record UpdateUserDTO(
    Long id,
    String name,
    String email,
    String password
) {

}
