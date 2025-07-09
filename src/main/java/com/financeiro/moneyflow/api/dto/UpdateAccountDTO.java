package com.financeiro.moneyflow.api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record UpdateAccountDTO(
    @NotBlank(message = "this id not null")
    Long id,
    @NotBlank(message = "this name not null")
    String name,
    @NotBlank(message = "this institution not null")
    String institution,
    @NotBlank(message = "this current balance not null")
    BigDecimal currentBalance,
    @NotBlank(message = "this user id not null")
    Long userId
) {

}
