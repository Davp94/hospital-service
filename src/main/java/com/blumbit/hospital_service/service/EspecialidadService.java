package com.blumbit.hospital_service.service;

import java.util.List;

import com.blumbit.hospital_service.dto.request.EspecialidadRequest;
import com.blumbit.hospital_service.dto.response.EspecialidadResponse;

public interface EspecialidadService { 
    List<EspecialidadResponse> findAllEspecialidades();

    EspecialidadResponse findEspecialidadById(Short id);

    EspecialidadResponse createEspecialidad(EspecialidadRequest especialidad);

    EspecialidadResponse updateEspecialidad(Short id, EspecialidadRequest especialidad);

    void deleteEspecialidadById(Short id);
}
