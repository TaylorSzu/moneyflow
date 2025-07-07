package com.financeiro.moneyflow.core.service;

import com.financeiro.moneyflow.core.domain.Account;
import com.financeiro.moneyflow.core.exception.ExistsIsNumberAccountException;
import com.financeiro.moneyflow.persistence.AccountRespository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRespository accountRespository;

    public Account create(Account account){
        Long random = ThreadLocalRandom.current().nextLong(100_000);
        existsNumberAccount(random);
        account.setNumberAccount(random);
        return accountRespository.save(account);
    }

    public void existsNumberAccount(Long number) {
        if (!accountRespository.existsByNumberAccount(number)){
            throw new ExistsIsNumberAccountException("This number account is use");
        }
    }
}
