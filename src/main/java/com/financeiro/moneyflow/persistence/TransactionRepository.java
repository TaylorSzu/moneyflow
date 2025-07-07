package com.financeiro.moneyflow.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financeiro.moneyflow.core.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
