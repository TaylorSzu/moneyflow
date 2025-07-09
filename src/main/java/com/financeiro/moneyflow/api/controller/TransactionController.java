package com.financeiro.moneyflow.api.controller;

import com.financeiro.moneyflow.api.dto.TransactionDTO;
import com.financeiro.moneyflow.api.dto.UpdateTransactionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.financeiro.moneyflow.api.dto.CreateTransactionDTO;
import com.financeiro.moneyflow.api.mapper.TransactionMapper;
import com.financeiro.moneyflow.core.domain.Account;
import com.financeiro.moneyflow.core.domain.Transaction;
import com.financeiro.moneyflow.core.service.AccountService;
import com.financeiro.moneyflow.core.service.TransactionService;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    private final AccountService accountService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public ResponseEntity<CreateTransactionDTO> create(@RequestBody CreateTransactionDTO dto) {
        Account account = accountService.findById(dto.accountId());
        Transaction transaction = transactionMapper.toTransaction(dto, account);
        CreateTransactionDTO response = transactionMapper.toCreateTransactionDTO(transactionService.save(transaction));
        return ResponseEntity.created(null).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> listAll() {
        List<TransactionDTO> response = transactionMapper.toTransactionDTOList(transactionService.listAll());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDTO> findById(@PathVariable Long id) {
        TransactionDTO response = transactionMapper.toTransactionDTO(transactionService.findById(id));
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateTransactionDTO dto) {
        Account account = accountService.findById(dto.id());
        transactionService.update(transactionMapper.toTransaction(dto, account));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
