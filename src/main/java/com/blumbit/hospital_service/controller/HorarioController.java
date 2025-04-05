package com.blumbit.hospital_service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.dto.response.HorarioResponse;
import com.blumbit.hospital_service.service.HorarioService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/horario")
public class HorarioController {

    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @GetMapping
    public List<HorarioResponse> getHorariosByFecha(@RequestParam LocalDateTime horFecha, @RequestParam Boolean disponible, @RequestParam Short docId) {
        return horarioService.findAllByFechaDisponibleDoctor(horFecha, disponible, docId);
    }

    @GetMapping("/mes")
    public List<HorarioResponse> getHorariosByMes(@RequestParam Integer mes, @RequestParam Boolean disponible, @RequestParam Short docId) {
        return horarioService.findAllByMesDisponibleDoctor(mes, disponible, docId);
    }
    

}
