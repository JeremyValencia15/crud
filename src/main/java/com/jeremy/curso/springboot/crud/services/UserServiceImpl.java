package com.jeremy.curso.springboot.crud.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeremy.curso.springboot.crud.entities.Role;
import com.jeremy.curso.springboot.crud.entities.User;
import com.jeremy.curso.springboot.crud.respositories.RoleRepository;
import com.jeremy.curso.springboot.crud.respositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public User save(User user) {
        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();

        optionalRoleUser.ifPresent(role -> roles.add(role));

        if(user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(role -> roles.add(role));
        }

        user.setRoles(roles);
        //Como encrciptar el password
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        return repository.save(user);
    }

    @Override
    public boolean existByUsername(String username) {
        return repository.existsByUsername(username);
    }

}
