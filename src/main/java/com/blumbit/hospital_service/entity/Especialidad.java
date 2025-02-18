package com.blumbit.hospital_service.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@Table(name = "especialidad", schema = "administracion")
public class Especialidad {

    @Id
    @Column(name = "esp_id")
    private Short espId;

    @Column(name = "esp_nombre")
    private String espNombre;

    @Column(name = "esp_descripcion")
    private String espDescripcion;

    @Column(name = "fecha_registro")
    private Instant fechaRegistro;

    @Column(name = "usuario_registro")
    private Short usuarioRegistro;

    // @OneToMany
    // List<Doctor> doctores;

    // Getters and Setters
}
