package com.jeremy.curso.springboot.crud.respositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.curso.springboot.crud.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    
    Optional<Role> findByName(String name);
}
