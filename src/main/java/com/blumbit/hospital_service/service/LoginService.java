package com.blumbit.hospital_service.service;

import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.request.LoginRequest;
import com.blumbit.hospital_service.dto.response.LoginResponse;
import com.blumbit.hospital_service.util.JwtUtil;

@Service
public class LoginService {

    private final JwtUtil jwtUtil;

    private final UsuarioSecurityServiceImpl usuarioSecurityServiceImpl;

    private final PacienteService pacienteService;

    public LoginResponse returnToken(LoginRequest loginRequest){
        //validar usuario 
    }

    //TODO add login validation & return token

}
