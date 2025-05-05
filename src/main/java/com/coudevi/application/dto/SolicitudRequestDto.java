package com.coudevi.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SolicitudRequestDto {
    private Long idUsuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String motivo;
    private String estado;
    private String observaciones;
    private LocalDate fechaCreacion;
    private LocalDate fechaResolucion;
    private Long revisadoPor;
}
