package com.blumbit.hospital_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.response.DoctorResponse;
import com.blumbit.hospital_service.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<DoctorResponse> findALlDoctoresByEspecialidad(Short espId) {
        return doctorRepository.findAllByEspecialidad_EspId(espId).stream().map(DoctorResponse::fromEntity).collect(Collectors.toList());
    }

}
