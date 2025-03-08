package com.blumbit.hospital_service.service;

import java.util.List;

import com.blumbit.hospital_service.dto.request.PacienteRequest;
import com.blumbit.hospital_service.dto.response.PacienteResponse;

public interface PacienteService {

    List<PacienteResponse> findAllPacientes();

    PacienteResponse findPacienteById(Short id);

    PacienteResponse findPacienteByUsername(String username);

    PacienteResponse findPacienteByToken(String token);

    PacienteResponse createPaciente(PacienteRequest Paciente);

    PacienteResponse updatePaciente(Short id, PacienteRequest Paciente);

    void deletePacienteById(Short id);

}
