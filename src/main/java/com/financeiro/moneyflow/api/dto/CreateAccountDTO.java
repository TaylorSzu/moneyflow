package com.financeiro.moneyflow.api.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;

public record CreateAccountDTO(
    @NotBlank(message = "this name not null")
    String name,
    @NotBlank(message = "this institution not null")
    String institution,
    @NotBlank(message = "this type not null")
    BigDecimal currentBalance,
    @NotBlank(message = "this type not null")
    Long userId
) {

}
