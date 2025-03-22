package com.blumbit.hospital_service.dto.response;

import java.time.LocalDateTime;
import java.time.LocalTime;
import com.blumbit.hospital_service.entity.Horario;
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
public class HorarioResponse {

    private LocalDateTime horFecha;

    private LocalTime horHoraInicio;

    private LocalTime horHoraFin;

    private Boolean horDisponible;

    private Short docId;


    public static HorarioResponse fromEntity(Horario horario){
        return HorarioResponse.builder()
                        .horFecha(horario.getHorFecha())
                        .horHoraInicio(horario.getHorHoraInicio())
                        .horHoraFin(horario.getHorHoraFin())
                        .horDisponible(horario.getHorDisponible())
                        .docId(horario.getDoctor().getDocId())
                        .build();
    }
}
