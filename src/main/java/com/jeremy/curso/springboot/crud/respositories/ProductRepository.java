package com.jeremy.curso.springboot.crud.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeremy.curso.springboot.crud.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
