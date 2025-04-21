package com.coudevi.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AreaResponseDto {
    private Long id;
    private String nombre;
}
