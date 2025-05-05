package com.coudevi.application.mapper;

import com.coudevi.application.dto.SolicitudRequestDto;
import com.coudevi.application.dto.SolicitudResponseDto;
import com.coudevi.domain.entity.Solicitud;
import com.coudevi.domain.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class SolicitudMapper {
    public SolicitudResponseDto toDto(Solicitud solicitud){
        return SolicitudResponseDto.builder()
                .id(solicitud.getId())
                .nombreUsuario(solicitud.getUsuario().getNombre())
                .fechaInicio(solicitud.getFechaInicio())
                .fechaFin(solicitud.getFechaFin())
                .motivo(solicitud.getMotivo())
                .estado(solicitud.getEstado())
                .observaciones(solicitud.getObservaciones())
                .fechaCreacion(solicitud.getFechaCreacion())
                .fechaResolucion(solicitud.getFechaResolucion())
                .revisadoUsuario(solicitud.getUsuario().getNombre())
                .build();
    }

    public Solicitud toEntity(SolicitudRequestDto requestDto, Usuario usuario){
        return  Solicitud.builder()
                .usuario(usuario)
                .fechaInicio(requestDto.getFechaInicio())
                .fechaFin(requestDto.getFechaFin())
                .motivo(requestDto.getMotivo())
                .estado(requestDto.getEstado())
                .observaciones(requestDto.getObservaciones())
                .fechaCreacion(requestDto.getFechaCreacion())
                .fechaResolucion(requestDto.getFechaResolucion())
                .revisadopor(usuario)
                .build();
    }
}
