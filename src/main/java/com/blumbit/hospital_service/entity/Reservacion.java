package com.blumbit.hospital_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservacion", schema = "administracion")
public class Reservacion {

    @Id
    @Column(name = "res_id")
    private Integer resId;

    @Column(name = "res_estado")
    private Short resEstado;

    @Column(name = "res_fecha_reserva")
    private Instant resFechaReserva;

    @ManyToOne
    @JoinColumn(name = "paciente_id", referencedColumnName = "pac_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doc_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "horario_id", referencedColumnName = "hor_id")
    private Horario horario;

    // Getters and Setters
}
