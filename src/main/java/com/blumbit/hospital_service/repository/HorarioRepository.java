package com.blumbit.hospital_service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import com.blumbit.hospital_service.entity.Horario;

public interface HorarioRepository extends ListCrudRepository<Horario, Integer>{
    
    @Query(value = 
    """
    select * from administracion.horario h where EXTRACT(MONTH FROM h.hor_fecha) = ?1 
    AND h.hor_disponible = ?2 AND h.doc_id = ?3 
    """, nativeQuery = true)
    List<Horario> findAllByMesDisponibleDoctor(int month,  Boolean disponible, Short id);

    List<Horario> findAllByHorFechaAndHorDisponibleAndDoctor_DocId(LocalDateTime horFecha, Boolean disponible, Short id);

    // @Query(value = "SELECT * FROM horario WHERE EXTRACT(MONTH FROM hor_fecha) = :month", 
    //     nativeQuery = true)
    // List<Horario> findByMonth(@Param("month") int month);

}
