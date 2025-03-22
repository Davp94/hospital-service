package com.blumbit.hospital_service.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.blumbit.hospital_service.entity.Reservacion;

public interface ReservacionPageRepository extends PagingAndSortingRepository<Reservacion, Integer>{

}
