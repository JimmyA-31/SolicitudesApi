package com.coudevi.application.mapper;

import com.coudevi.application.dto.UsuarioRequestDto;
import com.coudevi.application.dto.UsuarioResponseDto;
import com.coudevi.domain.entity.Area;
import com.coudevi.domain.entity.Rol;
import com.coudevi.domain.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponseDto toDto(Usuario usuario){
        return UsuarioResponseDto.builder()
                .id(usuario.getId())
                .nombre(usuario.getNombre())
                .correo(usuario.getCorreo())
                .contrasena(usuario.getContrasena())
                .nombreArea(usuario.getArea().getNombre())
                .build();
    }

    public Usuario toEntity(UsuarioRequestDto requestDto, Area area){
        return Usuario.builder()
                .nombre(requestDto.getNombre())
                .correo(requestDto.getCorreo())
                .contrasena(requestDto.getContrasena())
                .area(area)
                .build();
    }

    public Usuario toEntityUsuario(UsuarioResponseDto usuarioResponseDto) {
        return Usuario.builder()
                .id(usuarioResponseDto.getId())
                .nombre(usuarioResponseDto.getNombre())
                .correo(usuarioResponseDto.getCorreo())
                .contrasena(usuarioResponseDto.getContrasena())
                .build();
    }
}
