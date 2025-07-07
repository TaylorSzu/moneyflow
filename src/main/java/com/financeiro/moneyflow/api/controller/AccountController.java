package com.financeiro.moneyflow.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.moneyflow.api.dto.AccountDTO;
import com.financeiro.moneyflow.api.dto.CreateAccountDTO;
import com.financeiro.moneyflow.api.dto.UpdateAccountDTO;
import com.financeiro.moneyflow.api.mapper.AccountMapper;
import com.financeiro.moneyflow.core.domain.Account;
import com.financeiro.moneyflow.core.domain.User;
import com.financeiro.moneyflow.core.service.AccountService;
import com.financeiro.moneyflow.core.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final UserService userService;
    private final AccountMapper accountMapper;
    
    @PostMapping
    public ResponseEntity<CreateAccountDTO> create(@RequestBody CreateAccountDTO dto) {
        User user = userService.findById(dto.userId());
        Account account = accountMapper.toAccount(dto, user);
        CreateAccountDTO response = accountMapper.toCreateAccountDTO(accountService.create(account));
        return ResponseEntity.created(null).body(response);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateAccountDTO dto) {
        accountService.update(accountMapper.toAccount(dto));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AccountDTO>> listAll() {
        List<AccountDTO> response = accountMapper.toAccountDTOList(accountService.listAll());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> findById(@PathVariable Long id) {
        AccountDTO response = accountMapper.toAccountDTO(accountService.findById(id));
        return ResponseEntity.ok().body(response);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
