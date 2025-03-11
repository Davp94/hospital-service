package com.blumbit.hospital_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.dto.request.LoginRequest;
import com.blumbit.hospital_service.dto.response.LoginResponse;
import com.blumbit.hospital_service.service.LoginService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;
    
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public LoginResponse authUser(@RequestBody LoginRequest loginRequest) {      
        return loginService.returnToken(loginRequest);
    }
    
}
