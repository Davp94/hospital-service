package com.blumbit.hospital_service.dto.response;

import com.blumbit.hospital_service.entity.Especialidad;
import com.blumbit.hospital_service.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteResponse {

    private Short pacId;
    private String pacUsername;
    private String pacNombres;
    private String pacApellidos;
    private String pacPassword;
    private Short pacEstado;
    private String pacFoto;

    public static PacienteResponse fromEntity(Paciente paciente) {
        return PacienteResponse.builder()
                .pacId(paciente.getPacId())
                .pacNombres(paciente.getPacNombres())
                .pacApellidos(paciente.getPacApellidos())
                .pacUsername(paciente.getPacUsername())
                .pacEstado(paciente.getPacEstado())
                .pacFoto(paciente.getPacFoto())
                .build();
    }

    public static PacienteResponse fromEntitySecurity(Paciente paciente) {
        return PacienteResponse.builder()
                .pacId(paciente.getPacId())
                .pacNombres(paciente.getPacNombres())
                .pacApellidos(paciente.getPacApellidos())
                .pacUsername(paciente.getPacUsername())
                .pacEstado(paciente.getPacEstado())
                .pacPassword(paciente.getPacPassword())
                .pacFoto(paciente.getPacFoto())
                .build();
    }

}
