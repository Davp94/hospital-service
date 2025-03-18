package com.blumbit.hospital_service.dto.response;

import com.blumbit.hospital_service.entity.Horario;

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
    
    private Horario horario;

    private String docNombreCompleto;

    private String espNombre;

    private Short resEstado;

}
