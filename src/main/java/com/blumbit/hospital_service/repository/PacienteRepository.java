package com.blumbit.hospital_service.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.hospital_service.entity.Paciente;

public interface PacienteRepository extends ListCrudRepository<Paciente, Short>{

    Optional<Paciente> findByPacUsername(String username);

}
