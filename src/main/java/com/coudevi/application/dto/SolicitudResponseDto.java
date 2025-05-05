package com.coudevi.application.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SolicitudResponseDto {
    private Long id;
    private String nombreUsuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Integer diasSolicitados;
    private String motivo;
    private String estado;
    private String observaciones;
    private LocalDate fechaCreacion;
    private LocalDate fechaResolucion;
    private String revisadoUsuario;
}
