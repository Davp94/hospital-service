package com.blumbit.hospital_service.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.hospital_service.entity.Especialidad;

public interface EspecialidadRepository extends ListCrudRepository<Especialidad, Short>{
    // //Define custom query -- query methods
    // List<Especialidad> findAllByEspNombreContaining(String nombre);

    // @Query(value = "select from Especialidad where espNombre = ?1")
    // List<Especialidad> finddSearchByNombre(String nombre);
}
