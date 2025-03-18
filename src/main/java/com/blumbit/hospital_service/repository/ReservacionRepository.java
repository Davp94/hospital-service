package com.blumbit.hospital_service.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.hospital_service.entity.Reservacion;

public interface ReservacionRepository extends ListCrudRepository<Reservacion, Integer>{

    List<Reservacion> findAllByPaciente_PacUsername(String username);

    // List<Reservacion> findAllByPaciente(Paciente paciente);

}
