package com.blumbit.hospital_service.repository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.blumbit.hospital_service.entity.Horario;

public interface HorarioRepository extends ListCrudRepository<Horario, Integer> {

    @Query(value = """
            select * from administracion.horario h where EXTRACT(MONTH FROM h.hor_fecha) = ?1
            AND h.hor_disponible = ?2 AND h.doctor_id = ?3
            """, nativeQuery = true)
    List<Horario> findAllByMesDisponibleDoctor(int month, Boolean disponible, Short id);

    @Query("SELECT h FROM Horario h WHERE CAST(h.horFecha AS LocalDate) = :date AND h.horDisponible = :disponible AND h.doctor.docId = :docId")
    List<Horario> findAllByDateAndDisponibleAndDoctor(@Param("date") LocalDate date,
            @Param("disponible") Boolean disponible, @Param("docId") Short docId);

    // @Query(value = "SELECT * FROM horario WHERE EXTRACT(MONTH FROM hor_fecha) =
    // :month",
    // nativeQuery = true)
    // List<Horario> findByMonth(@Param("month") int month);

}
