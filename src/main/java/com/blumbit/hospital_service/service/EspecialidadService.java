package com.blumbit.hospital_service.service;

import java.util.List;

import com.blumbit.hospital_service.entity.Especialidad;

public interface EspecialidadService { 
    List<Especialidad> findAllEspecialidades();

    Especialidad findEspecialidadById(Short id);

    Especialidad createEspecialidad(Especialidad especialidad);

    Especialidad updateEspecialidad(Especialidad especialidad);

    void deleteEspecialidadById(Short id);
}
