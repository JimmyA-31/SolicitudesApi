package com.coudevi.application.service;

import com.coudevi.application.dto.RolRequestDto;
import com.coudevi.application.dto.RolResponseDto;
import com.coudevi.domain.entity.Rol;

import java.util.List;

public interface IRolService {
    List<RolResponseDto> listar();
    RolResponseDto guardar(RolRequestDto requestDto);
    void eliminar(Long id);
    RolResponseDto obtenerRol(Long id);
}
