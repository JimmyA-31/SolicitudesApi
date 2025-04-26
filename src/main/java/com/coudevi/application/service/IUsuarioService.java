package com.coudevi.application.service;

import com.coudevi.application.dto.UsuarioRequestDto;
import com.coudevi.application.dto.UsuarioResponseDto;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioResponseDto> listar();
    UsuarioResponseDto guardar(UsuarioRequestDto requestDTO);
    void eliminar(Long id);
    UsuarioResponseDto obtenerUsuario(Long id);
}
