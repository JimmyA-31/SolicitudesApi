package com.coudevi.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponseDto {
    private Long id;
    private String nombre;
    private String correo;
    private String contrasena;
    private String nombreArea;
}
