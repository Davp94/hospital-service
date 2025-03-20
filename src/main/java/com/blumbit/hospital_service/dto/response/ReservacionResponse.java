package com.blumbit.hospital_service.dto.response;


import com.blumbit.hospital_service.dto.request.EspecialidadRequest;
import com.blumbit.hospital_service.entity.Especialidad;
import com.blumbit.hospital_service.entity.Reservacion;

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
public class ReservacionResponse {
    
    private HorarioResponse horarioResponse;

    private String docNombreCompleto;

    private String espNombre;

    private Short resEstado;

    public static ReservacionResponse fromEntity(Reservacion reservacion){
    return ReservacionResponse.builder()
                    .horarioResponse(HorarioResponse.fromEntity(reservacion.getHorario()))
                    .docNombreCompleto(reservacion.getDoctor().getDocNombre() + " " + reservacion.getDoctor().getDocApellidos())
                    .resEstado(reservacion.getResEstado())
                    .build();
    }

}
