package com.blumbit.hospital_service.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReservacionRequest {

    private Short pacId;

    private Short docId;

    private Integer horId; 

}
