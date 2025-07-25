package com.financeiro.moneyflow.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.financeiro.moneyflow.core.domain.User;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByEmailAndIdNot(String email, Long id);
    Optional<User> findByEmailAndPassword(String email, String password);

}
