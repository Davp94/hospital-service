package com.blumbit.hospital_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.dto.response.DoctorResponse;
import com.blumbit.hospital_service.service.DoctorService;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<DoctorResponse> findAllByEspecialidad(@RequestParam Short espId){
        return doctorService.findALlDoctoresByEspecialidad(espId);
    }

}
