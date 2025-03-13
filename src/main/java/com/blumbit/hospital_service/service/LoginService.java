package com.blumbit.hospital_service.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.request.LoginRequest;
import com.blumbit.hospital_service.dto.response.LoginResponse;
import com.blumbit.hospital_service.util.JwtUtil;

@Service
public class LoginService {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public LoginService(JwtUtil jwtUtil,
            AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public LoginResponse returnToken(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
                loginRequest.getPassword());
        authenticationManager.authenticate(login);
        String token = jwtUtil.generateToken(loginRequest.getUsername());
        String retrieveUser = jwtUtil.getUsernameFromToken(token);
        return LoginResponse.builder()
                .token(token)
                .build();
    }

}
