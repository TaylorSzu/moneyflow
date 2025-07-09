package com.financeiro.moneyflow.core.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.financeiro.moneyflow.core.domain.Account;
import com.financeiro.moneyflow.core.domain.Transaction;
import com.financeiro.moneyflow.core.exception.NotFoundException;
import com.financeiro.moneyflow.persistence.TransactionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    public Transaction save(Transaction transaction) {
        transaction.setDate(java.time.LocalDate.now());
        updateCurrentBanlace(transaction.getAccount().getId(), transaction);
        return transactionRepository.save(transaction);
    }

    public void update(Transaction transaction) {
        findById(transaction.getId());
        transactionRepository.save(transaction);
    }

    public List<Transaction> listAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Transaction not found with id:"));
    }

    public void delete(Long id) {
        transactionRepository.deleteById(id);
    }

    public BigDecimal updateCurrentBanlace(Long id, Transaction transaction) {
        Account account = accountService.findById(id);
        BigDecimal currentBalance = account.getCurrentBalance();
        BigDecimal result = new BigDecimal(0);
        if (transaction.getType().name() == "REVENUE") {
            result = currentBalance.add(transaction.getValue());
        }else if (transaction.getType().name() == "EXPENSE") {
            result = currentBalance.subtract(transaction.getValue());
        } else {
            throw new IllegalArgumentException("Invalid transaction type: " + transaction.getType());
        }
        return result;
    }
}
