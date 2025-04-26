package com.coudevi.web.controller;

import com.coudevi.application.dto.UsuarioRequestDto;
import com.coudevi.application.dto.UsuarioResponseDto;
import com.coudevi.application.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final IUsuarioService service;

    @GetMapping
    public List<UsuarioResponseDto> listar(){
        return service.listar();
    }

    @PostMapping
    public UsuarioResponseDto guardar(@RequestBody UsuarioRequestDto requestDto){
        return service.guardar(requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public UsuarioResponseDto obtenerUsuario(@PathVariable Long id){
        return service.obtenerUsuario(id);
    }
}
