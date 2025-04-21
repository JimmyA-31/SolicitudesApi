package com.coudevi.application.mapper;

import com.coudevi.application.dto.RolRequestDto;
import com.coudevi.application.dto.RolResponseDto;
import com.coudevi.domain.entity.Rol;
import org.springframework.stereotype.Component;

@Component
public class RolMapper {
    public RolResponseDto toDto(Rol rol) {
        return RolResponseDto.builder()
                .id(rol.getId())
                .nombre(rol.getNombre())
                .build();
    }

    public Rol toEntity(RolRequestDto requestDto) {
        return Rol.builder()
                .nombre(requestDto.getNombre())
                .build();
    }

    public Rol toEntityRol(RolResponseDto responseDto) {
        return Rol.builder()
                .id(responseDto.getId())
                .nombre(responseDto.getNombre())
                .build();
    }
}
