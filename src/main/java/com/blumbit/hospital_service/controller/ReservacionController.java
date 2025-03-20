package com.blumbit.hospital_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.dto.request.ReservacionRequest;
import com.blumbit.hospital_service.dto.response.ReservacionResponse;
import com.blumbit.hospital_service.service.ReservacionService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/reservacion")
public class ReservacionController {

    private final ReservacionService reservacionService;

    public ReservacionController(ReservacionService reservacionService) {
        this.reservacionService = reservacionService;
    }

    @GetMapping
    public List<ReservacionResponse> findReservacionesByPaciente(@RequestParam String username) {
        return reservacionService.findReservacionesByPaciente(username);
    }

    @PostMapping
    public ReservacionResponse postMethodName(@RequestBody ReservacionRequest reservacionRequest) {     
        return reservacionService.createReservacion(reservacionRequest);
    }   

}
