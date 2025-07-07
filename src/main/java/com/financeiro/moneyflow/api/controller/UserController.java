package com.financeiro.moneyflow.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.financeiro.moneyflow.api.dto.UpdateUserDTO;
import com.financeiro.moneyflow.api.dto.UserDTO;
import com.financeiro.moneyflow.api.mapper.UserMapper;
import com.financeiro.moneyflow.core.domain.User;
import com.financeiro.moneyflow.core.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        UserDTO response = userMapper.toUserDTO(userService.create(user));
        return ResponseEntity.created(null).body(response);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateUserDTO dto) {
        userService.update(userMapper.toUser(dto));
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listAll() {
       List<UserDTO> response = userMapper.toUserDTOList(userService.listAll());
       return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO response = userMapper.toUserDTO(userService.findById(id));
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
