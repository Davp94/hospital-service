package com.blumbit.hospital_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.request.EspecialidadRequest;
import com.blumbit.hospital_service.dto.response.EspecialidadResponse;
import com.blumbit.hospital_service.entity.Especialidad;
import com.blumbit.hospital_service.repository.EspecialidadRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EspecialidadServiceImpl implements EspecialidadService{

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public List<EspecialidadResponse> findAllEspecialidades() {
        // List<Especialidad> especialidades = especialidadRepository.findAll();
        // List<EspecialidadResponse> especialidadesResponse = new ArrayList<>();

        // especialidades.forEach(especialidad -> {
        //     EspecialidadResponse especialidadResponse = EspecialidadResponse.fromEntity(especialidad);
        //     especialidadesResponse.add(especialidadResponse);
        // });
        // for(int i =0; i<especialidades.size(); i++){
        //     EspecialidadResponse especialidadResponse = EspecialidadResponse.fromEntity(especialidades.get(i));
        //     especialidadesResponse.add(especialidadResponse); 
        // }
        return especialidadRepository.findAll().stream().map(EspecialidadResponse::fromEntity).collect(Collectors.toList());
    }

    @Override
    public EspecialidadResponse findEspecialidadById(Short id) {
        Especialidad especialidadFinded = especialidadRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("No se encuentra la especliadidad con el id solicitado"));
        return EspecialidadResponse.fromEntity(especialidadFinded);
    }

    @Override
    public EspecialidadResponse createEspecialidad(EspecialidadRequest especialidadRequest) {
        Especialidad especialidadToCreate = EspecialidadRequest.toEntity(especialidadRequest);
        especialidadToCreate.setEspId((short) (especialidadRepository.count()+1));
        return EspecialidadResponse.fromEntity(especialidadRepository.save(especialidadToCreate));
    }

    @Override
    public EspecialidadResponse updateEspecialidad(Short id, EspecialidadRequest especialidad) {
        Especialidad especialidadFinded = especialidadRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encuentra la especliadidad con el id solicitado"));
        especialidadFinded.setEspDescripcion(especialidad.getEspDescripcion());
        especialidadFinded.setEspNombre(especialidad.getEspNombre());
        return EspecialidadResponse.fromEntity(especialidadRepository.save(especialidadFinded));

    }

    @Override
    public void deleteEspecialidadById(Short id) {
        especialidadRepository.deleteById(id);
    }

}
