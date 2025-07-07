package com.financeiro.moneyflow.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.financeiro.moneyflow.core.domain.User;
import com.financeiro.moneyflow.core.exception.EmailAlreadyUseException;
import com.financeiro.moneyflow.core.exception.NotEditEmailException;
import com.financeiro.moneyflow.core.exception.NotFoundException;
import com.financeiro.moneyflow.persistence.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User create(User user) {
        emailAlreadyIsUse(user.getId(), user.getEmail());
        return userRepository.save(user);
    }

    public void update(User user){
        User foundUser = findById(user.getId());
        if(user.getEmail() == foundUser.getEmail()){
            throw new NotEditEmailException("Email Can not be editable");
        }
        userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void delete(Long id) {
        findById(id);
        userRepository.deleteById((id));
    }

    public Optional<User> login(String email, String password) {
        return Optional.ofNullable(userRepository.findByEmailAndPassword(email, password).orElseThrow(() -> new NotFoundException("User not found") ));
    }

    public void emailAlreadyIsUse(Long id, String email){
        if(userRepository.existsByEmailAndIdNot(email, id)) {
            throw new EmailAlreadyUseException("This email is already in use by  another user");
        }
    }
}
