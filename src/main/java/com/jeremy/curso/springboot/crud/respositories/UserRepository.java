package com.jeremy.curso.springboot.crud.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.curso.springboot.crud.entities.User;


public interface UserRepository extends JpaRepository<User, Long>{
    boolean existsByUsername(String username);
    
    Optional<User> findByUsername(String username);
}
