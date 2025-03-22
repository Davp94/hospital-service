package com.blumbit.hospital_service.dto.response;

import java.util.List;

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
public class PageResponseDto<T> {
    private List<T> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElementes;
    private Integer totalPages;
}
