package com.blumbit.hospital_service.service;

import java.util.List;

import com.blumbit.hospital_service.dto.response.DoctorResponse;

public interface DoctorService {

    List<DoctorResponse> findALlDoctoresByEspecialidad(Short espId);

}
