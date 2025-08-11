package com.jeremy.curso.springboot.crud.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jeremy.curso.springboot.crud.validation.ExistByUsername;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ExistByUsername
    @Column(unique = true)
    @NotBlank
    @Size(min = 4, max = 12)
    private String username;

    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//Esto permite ocultar en caso de que no querramos usar un DTO
    private String password;

    @ManyToMany
    @JoinTable(name = "users_roles", 
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"),
    uniqueConstraints = { @UniqueConstraint(columnNames = {"user_id", "role_id"})})
    private List<Role> roles;
    
    private boolean enabled;
    
    //De esta manera usamos las buenas practicas para settear un valor por defecto de manera correcta
    @PrePersist
    public void prePersist(){
        enabled = true;
    }
    
    //Este campo no esta mapeado a un atributo de la tabla
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean admin;
}
