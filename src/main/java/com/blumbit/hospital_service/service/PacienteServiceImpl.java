package com.blumbit.hospital_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.common.MessageService;
import com.blumbit.hospital_service.dto.request.PacienteRequest;
import com.blumbit.hospital_service.dto.response.PacienteResponse;
import com.blumbit.hospital_service.entity.Paciente;
import com.blumbit.hospital_service.repository.PacienteRepository;
import com.blumbit.hospital_service.util.JwtUtil;

@Service
public class PacienteServiceImpl implements PacienteService{

    private final PacienteRepository pacienteRepository;

    private final MessageService messageService;

    private final JwtUtil jwtUtil;

    public PacienteServiceImpl(PacienteRepository pacienteRepository, MessageService messageService, JwtUtil jwtUtil) {
        this.pacienteRepository = pacienteRepository;
        this.messageService = messageService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public List<PacienteResponse> findAllPacientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllPacientes'");
    }

    @Override
    public PacienteResponse findPacienteById(Short id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findPacienteById'");
    }

    @Override
    public PacienteResponse findPacienteByUsername(String username) {
        Paciente pacienteRetrieved = pacienteRepository.findByPacUsername(username).orElseThrow(()-> new RuntimeException(messageService.getMessage("usuario.not.found")));
        return PacienteResponse.fromEntity(pacienteRetrieved);
    }

    @Override
    public PacienteResponse createPaciente(PacienteRequest Paciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPaciente'");
    }

    @Override
    public PacienteResponse updatePaciente(Short id, PacienteRequest Paciente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePaciente'");
    }

    @Override
    public void deletePacienteById(Short id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePacienteById'");
    }

    @Override
    public PacienteResponse findPacienteByToken(String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return findPacienteByUsername(username);
    }

}
