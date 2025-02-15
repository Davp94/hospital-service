package com.blumbit.hospital_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.entity.Especialidad;
import com.blumbit.hospital_service.repository.EspecialidadRepository;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public List<Especialidad> findAllEspecialidades() {
        return especialidadRepository.findAll();
    }

    @Override
    public Especialidad findEspecialidadById(Short id) {
        return especialidadRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encuentra la especliadidad con el id solicitado"));
    }

    @Override
    public Especialidad createEspecialidad(Especialidad especialidad) {
        return especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad updateEspecialidad(Especialidad especialidad) {
        Especialidad especialidadFinded = findEspecialidadById(especialidad.getEspId());
        especialidadFinded.setEspDescripcion(especialidad.getEspDescripcion());
        especialidadFinded.setEspNombre(especialidad.getEspNombre());
        return especialidadRepository.save(especialidadFinded);

    }

    @Override
    public void deleteEspecialidadById(Short id) {
        especialidadRepository.deleteById(id);
    }

}
