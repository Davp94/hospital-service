package com.blumbit.hospital_service.entity;

import javax.persistence.*;

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

    // @OneToMany
    // List<Doctor> doctores;

    // Getters and Setters
}
