package com.blumbit.hospital_service.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.hospital_service.entity.Doctor;

public interface DoctorRepository extends ListCrudRepository<Doctor, Short>{

    List<Doctor> findAllByEspecialidad_EspId(Short espId);

    Doctor findAllByDocRs(String rs);

    Doctor findAllByDocNombre(String nombre);
}
