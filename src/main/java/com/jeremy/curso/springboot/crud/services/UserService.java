package com.jeremy.curso.springboot.crud.services;

import java.util.List;

import com.jeremy.curso.springboot.crud.entities.User;

public interface UserService {

    List<User> findAll();

    User save(User user);
}
