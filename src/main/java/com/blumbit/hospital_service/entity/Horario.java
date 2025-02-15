package com.blumbit.hospital_service.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "horario", schema = "administracion")
public class Horario {

    @Id
    @Column(name = "hor_id")
    private Integer horId;

    @Column(name = "hor_fecha")
    private LocalDateTime horFecha;

    @Column(name = "hor_hora_inicio")
    private LocalTime horHoraInicio;

    @Column(name = "hor_hora_fin")
    private LocalTime horHoraFin;

    @Column(name = "hor_disponible")
    private Boolean horDisponible;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doc_id")
    private Doctor doctor;

    // Getters and Setters
}