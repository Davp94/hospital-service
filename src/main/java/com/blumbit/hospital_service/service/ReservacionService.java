package com.blumbit.hospital_service.service;

import java.util.List;

import com.blumbit.hospital_service.dto.request.PageRequestDto;
import com.blumbit.hospital_service.dto.request.ReservacionRequest;
import com.blumbit.hospital_service.dto.response.PageResponseDto;
import com.blumbit.hospital_service.dto.response.ReservacionResponse;

public interface ReservacionService {

    List<ReservacionResponse> findReservacionesByPaciente(String username);

    PageResponseDto<ReservacionResponse> findPaginationReservaciones(PageRequestDto pageRequestDto);

    ReservacionResponse createReservacion(ReservacionRequest reservacionRequest);
}
