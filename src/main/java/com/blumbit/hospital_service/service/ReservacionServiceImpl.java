package com.blumbit.hospital_service.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.request.ReservacionRequest;
import com.blumbit.hospital_service.dto.response.ReservacionResponse;
import com.blumbit.hospital_service.entity.Doctor;
import com.blumbit.hospital_service.entity.Horario;
import com.blumbit.hospital_service.entity.Paciente;
import com.blumbit.hospital_service.entity.Reservacion;
import com.blumbit.hospital_service.repository.ReservacionRepository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReservacionServiceImpl implements ReservacionService{

    private final ReservacionRepository reservacionRepository;

    private final EntityManager entityManager;

    public ReservacionServiceImpl(ReservacionRepository reservacionRepository, EntityManager entityManager) {
        this.reservacionRepository = reservacionRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<ReservacionResponse> findReservacionesByPaciente(String username) {
        return reservacionRepository.findAllByPaciente_PacUsername(username).stream().map(ReservacionResponse::fromEntity).collect(Collectors.toList());
    }

    @Override
    public ReservacionResponse createReservacion(ReservacionRequest reservacionRequest) {
        try {
            if(this.validationsReservacion(reservacionRequest)){
                Reservacion reservacion = new Reservacion();
                reservacion.setDoctor(entityManager.getReference(Doctor.class, reservacionRequest.getDocId()));
                reservacion.setPaciente(entityManager.getReference(Paciente.class, reservacionRequest.getPacId()));
                reservacion.setHorario(entityManager.getReference(Horario.class, reservacionRequest.getHorId()));
                reservacion.setResEstado((short)1);
                reservacion.setResFechaReserva(Instant.now());
                Reservacion reservacionSaved = reservacionRepository.save(reservacion);
                return ReservacionResponse.fromEntity(reservacionSaved);
            } else {
                throw new RuntimeException("Error al validar los datos ingresados");
            }
               
        } catch (RuntimeException e) {
            log.debug(e.getMessage(), e);
            throw new RuntimeException("Error al crear una reservacion");
        }
        
    }

    private Boolean validationsReservacion(ReservacionRequest reservacionRequest){
        return true;
    }


}
