package com.blumbit.hospital_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.dto.response.HorarioResponse;
import com.blumbit.hospital_service.repository.HorarioRepository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HorarioServiceImpl implements HorarioService{

    private final HorarioRepository horarioRepository;

    private final EntityManager entityManager;

    public HorarioServiceImpl(HorarioRepository horarioRepository, EntityManager entityManager) {
        this.horarioRepository = horarioRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<HorarioResponse> findAllByMesDisponibleDoctor(int month, Boolean disponible, Short docId) {
        try {
            return horarioRepository.findAllByMesDisponibleDoctor(month, disponible, docId).stream().map(HorarioResponse::fromEntity).collect(Collectors.toList());
        } catch (RuntimeException e) {
            log.debug(e.getMessage(), e);
            throw new RuntimeException("Error al listar los horarios por mes");
        }
    }

    @Override
    public List<HorarioResponse> findAllByFechaDisponibleDoctor(LocalDateTime horFecha, Boolean disponible,
            Short docId) {
        try {
            return horarioRepository.findAllByHorFechaAndHorDisponibleAndDoctor_DocId(horFecha, disponible, docId).stream().map(HorarioResponse::fromEntity).collect(Collectors.toList());
        } catch (RuntimeException e) {
            log.debug(e.getMessage(), e);
            throw new RuntimeException("Error al listar los horarios por fecha");
        }
    }

}
