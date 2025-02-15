package com.blumbit.hospital_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor", schema = "administracion")
public class Doctor {

    @Id
    @Column(name = "doc_id")
    private Short docId;

    @Column(name = "doc_nombre")
    private String docNombre;

    @Column(name = "doc_apellidos")
    private String docApellidos;

    @Column(name = "doc_rs")
    private String docRs;

    @ManyToOne
    @JoinColumn(name = "especialidad_id", referencedColumnName = "esp_id")
    private Especialidad especialidad;

    // Getters and Setters
}