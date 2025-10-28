package com.coudevi.application.service;

import com.coudevi.application.dto.SolicitudRequestDto;
import com.coudevi.application.dto.SolicitudResponseDto;

import java.util.List;

public interface ISolicitudService {
    List<SolicitudResponseDto> listar();
    SolicitudResponseDto guardar(SolicitudRequestDto requestDto);
    void eliminar(Long id);
    SolicitudResponseDto obtenerSolicitud(Long id);
    SolicitudResponseDto actualizar(SolicitudRequestDto requestDto);

}
