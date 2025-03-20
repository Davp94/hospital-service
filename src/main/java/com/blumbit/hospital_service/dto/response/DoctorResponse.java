package com.blumbit.hospital_service.dto.response;

import com.blumbit.hospital_service.entity.Doctor;

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
public class DoctorResponse {

    private Short docId;

    private String nombreCompleto;

    private String especialidad;

    private Short espId;

    public static DoctorResponse fromEntity(Doctor doctor){
        return DoctorResponse.builder()
                    .docId(doctor.getDocId())
                    .nombreCompleto(doctor.getDocNombre() + " "+doctor.getDocApellidos())
                    .especialidad(doctor.getEspecialidad().getEspNombre())
                    .espId(doctor.getEspecialidad().getEspId())
                    .build();
    }
}
