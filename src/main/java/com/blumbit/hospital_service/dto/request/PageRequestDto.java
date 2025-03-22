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
public class PageRequestDto {
    private Integer page; //10

    private Integer size; //10

    private String sortBy; //fecha

    private String direction; //ASC - DESC

    private String searchParam;
}
