package com.coudevi.application.service;

import com.coudevi.application.dto.AreaRequestDto;
import com.coudevi.application.dto.AreaResponseDto;
import com.coudevi.domain.entity.Area;

import java.util.List;

public interface IAreaService {
    List<AreaResponseDto> listar();
    AreaResponseDto guardar(AreaRequestDto requestDto);
    void eliminar(Long id);
    AreaResponseDto obtenerArea(Long id);
}
