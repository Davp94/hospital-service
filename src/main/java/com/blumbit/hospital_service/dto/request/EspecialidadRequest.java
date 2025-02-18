package com.blumbit.hospital_service.dto.request;

import com.blumbit.hospital_service.dto.response.EspecialidadResponse;
import com.blumbit.hospital_service.entity.Especialidad;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EspecialidadRequest {

    private String espNombre;

    private String espDescripcion;

    public static Especialidad toEntity(EspecialidadRequest especialidadRequest){
    return Especialidad.builder()
                    .espNombre(especialidadRequest.getEspNombre())
                    .espDescripcion(especialidadRequest.getEspDescripcion())
                    .build();
    }
}
