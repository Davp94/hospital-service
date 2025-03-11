package com.blumbit.hospital_service.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.response.PacienteResponse;

@Service
public class UsuarioSecurityServiceImpl implements UserDetailsService{

    private final PacienteService pacienteService;

    public UsuarioSecurityServiceImpl(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       PacienteResponse pacienteRetrieved = pacienteService.findPacienteByUsername(username);
       return User.builder()
                .username(pacienteRetrieved.getPacUsername())
                .password(pacienteRetrieved.getPacPassword())
                .build();
    }


}
