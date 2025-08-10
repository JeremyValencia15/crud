package com.jeremy.curso.springboot.crud.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.curso.springboot.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
