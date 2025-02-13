package com.blumbit.hospital_service.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "paciente", schema = "administracion")
public class Paciente {

    @Id
    @Column(name = "pac_id")
    private Short pacId;

    @Column(name = "pac_username", length = 50, unique = true)
    private String pacUsername;

    @Column(name = "pac_password")
    private String pacPassword;

    @Column(name = "pac_nombres")
    private String pacNombres;

    @Column(name = "pac_apellidos")
    private String pacApellidos;

    @Column(name = "pac_dni")
    private String pacDni;

    @Column(name = "pac_estado")
    private Short pacEstado = 1;

    @Column(name = "pac_foto")
    private String pacFoto;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    @Column(name = "fecha_baja")
    private LocalDateTime fechaBaja;

    @Column(name = "usuario_registro")
    private Short usuarioRegistro;

    @Column(name = "usuario_modificacion")
    private Short usuarioModificacion;

    @Column(name = "usuario_baja")
    private Short usuarioBaja;

    // Getters and Setters
}
