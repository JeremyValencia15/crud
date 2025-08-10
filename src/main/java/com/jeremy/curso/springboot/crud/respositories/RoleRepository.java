package com.jeremy.curso.springboot.crud.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.curso.springboot.crud.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
