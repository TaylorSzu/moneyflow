package com.financeiro.moneyflow.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.moneyflow.core.domain.Account;

public interface AccountRespository extends JpaRepository<Account, Long>{
    boolean existsByNumberAccount(Long number);
}
