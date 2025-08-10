package com.jeremy.curso.springboot.crud.entities;

import com.jeremy.curso.springboot.crud.validation.isRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Setter @Getter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @isRequired
    @Size(min=3, max = 120)
    private String name;

    @Min(500)
    @NotNull
    private Integer price;

    @isRequired
    private String description;
}
