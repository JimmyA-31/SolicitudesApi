package com.coudevi.application.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioRequestDto {
    private String nombre;
    private String correo;
    private String contrasena;
    private Long idArea;
}
