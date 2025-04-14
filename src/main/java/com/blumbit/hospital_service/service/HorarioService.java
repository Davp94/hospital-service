package com.blumbit.hospital_service.service;

import java.time.LocalDateTime;
import java.util.List;

import com.blumbit.hospital_service.dto.response.HorarioResponse;

public interface HorarioService {

    List<HorarioResponse> findAllByMesDisponibleDoctor(int month,  Boolean disponible, Short docId);

    List<HorarioResponse> findAllByFechaDisponibleDoctor(String horFecha,  Boolean disponible, Short docId);

}
