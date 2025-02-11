package com.blumbit.hospital_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    private Integer id;

    @Column(unique = true)
    private String username;
    
    private String password;
}
