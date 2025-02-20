package com.blumbit.hospital_service.dto.response;

import com.blumbit.hospital_service.entity.Especialidad;

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
public class EspecialidadResponse {
 
    private Short espId;

    private String espNombre;

    private String espDescripcion;

    public static EspecialidadResponse fromEntity(Especialidad especialdad){
        return EspecialidadResponse.builder()
                        .espId(especialdad.getEspId())
                        .espNombre(especialdad.getEspNombre())
                        .espDescripcion(especialdad.getEspDescripcion())
                        .build();
    }
}
