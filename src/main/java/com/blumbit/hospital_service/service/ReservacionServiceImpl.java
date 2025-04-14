package com.blumbit.hospital_service.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.request.PageRequestDto;
import com.blumbit.hospital_service.dto.request.ReservacionRequest;
import com.blumbit.hospital_service.dto.response.PageResponseDto;
import com.blumbit.hospital_service.dto.response.ReservacionResponse;
import com.blumbit.hospital_service.entity.Doctor;
import com.blumbit.hospital_service.entity.Horario;
import com.blumbit.hospital_service.entity.Paciente;
import com.blumbit.hospital_service.entity.Reservacion;
import com.blumbit.hospital_service.repository.ReservacionPageRepository;
import com.blumbit.hospital_service.repository.ReservacionRepository;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReservacionServiceImpl implements ReservacionService{

    private final ReservacionRepository reservacionRepository;

    private final EntityManager entityManager;

    private final ReservacionPageRepository reservacionPageRepository;

    public ReservacionServiceImpl(ReservacionRepository reservacionRepository, EntityManager entityManager, ReservacionPageRepository reservacionPageRepository) {
        this.reservacionRepository = reservacionRepository;
        this.entityManager = entityManager;
        this.reservacionPageRepository = reservacionPageRepository;
    }

    @Override
    public List<ReservacionResponse> findReservacionesByPaciente(String username) {
        return reservacionRepository.findAllByPaciente_PacUsername(username).stream().map(ReservacionResponse::fromEntity).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ReservacionResponse createReservacion(ReservacionRequest reservacionRequest) {
        try {
            if(this.validationsReservacion(reservacionRequest)){
                Horario horario = entityManager.find(Horario.class, reservacionRequest.getHorId());
                horario.setHorDisponible(false);
                entityManager.merge(horario);
                entityManager.flush();
                Reservacion reservacion = new Reservacion();
                reservacion.setDoctor(entityManager.getReference(Doctor.class, reservacionRequest.getDocId()));
                reservacion.setPaciente(entityManager.getReference(Paciente.class, reservacionRequest.getPacId()));
                reservacion.setHorario(entityManager.getReference(Horario.class, reservacionRequest.getHorId()));
                reservacion.setResEstado((short)1);
                reservacion.setResFechaReserva(Instant.now());
                reservacion.setResId((int)(reservacionRepository.count()+1));
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

    @Override
    public PageResponseDto<ReservacionResponse> findPaginationReservaciones(PageRequestDto pageRequestDto) {
        Sort sort = Sort.by(
                pageRequestDto.getDirection().equalsIgnoreCase("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC,
                pageRequestDto.getSortBy());

        PageRequest pageable = PageRequest.of(pageRequestDto.getPage(), pageRequestDto.getSize(), sort);

        Page<Reservacion> reservacionPage = reservacionPageRepository.findAll(pageable);
        List<ReservacionResponse> reservacionResponses = reservacionPage.getContent().stream()
                .map(ReservacionResponse::fromEntity).collect(Collectors.toList());

        return PageResponseDto.<ReservacionResponse>builder()
                        .content(reservacionResponses)
                        .pageNumber(reservacionPage.getNumber())
                        .pageSize(reservacionPage.getSize())
                        .totalElementes(reservacionPage.getTotalElements())
                        .totalPages(reservacionPage.getTotalPages())
                        .build();

    }

}
