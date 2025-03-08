package com.blumbit.hospital_service.dto.response;

import com.blumbit.hospital_service.entity.Especialidad;
import com.blumbit.hospital_service.entity.Paciente;

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
public class PacienteResponse {

    private Short pacId;
    private String pacUsername;
    private String pacNombres;
    private String pacApellidos;
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

}
