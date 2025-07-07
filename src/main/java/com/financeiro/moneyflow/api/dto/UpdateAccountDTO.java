package com.financeiro.moneyflow.api.dto;

import java.math.BigDecimal;

public record UpdateAccountDTO(
    Long id,
    String name,
    String institution,
    BigDecimal currentBalance
) {

}
