package com.blumbit.hospital_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.dto.response.PacienteResponse;
import com.blumbit.hospital_service.service.PacienteService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("")
    public PacienteResponse getMethodName(HttpServletRequest httpServletRequest) {
        return pacienteService.findPacienteByToken(httpServletRequest.getHeader("Authorization").substring(7));
    }
    

}
