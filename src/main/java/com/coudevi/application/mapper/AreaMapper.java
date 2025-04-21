package com.coudevi.application.mapper;

import com.coudevi.application.dto.AreaRequestDto;
import com.coudevi.application.dto.AreaResponseDto;
import com.coudevi.domain.entity.Area;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper {
    public AreaResponseDto toDto(Area area) {
        return AreaResponseDto.builder()
                .id(area.getId())
                .nombre(area.getNombre())
                .build();
    }

    public Area toEntity(AreaRequestDto requestDto) {
        return Area.builder()
                .nombre(requestDto.getNombre())
                .build();
    }

    public Area toEntityArea(AreaResponseDto responseDto) {
        return Area.builder()
                .id(responseDto.getId())
                .nombre(responseDto.getNombre())
                .build();
    }
}
