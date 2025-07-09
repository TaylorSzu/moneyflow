package com.financeiro.moneyflow.api.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDTO(
    @NotBlank(message = "this id not null")
    Long id,
    @NotBlank(message = "this name not null")
    String name,
    @NotBlank(message = "this email not null")
    String email,
    @NotBlank(message = "this password not null")
    String password
) {

}
