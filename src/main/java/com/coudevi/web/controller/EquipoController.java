package com.coudevi.web.controller;

import com.coudevi.application.dto.RolRequestDto;
import com.coudevi.application.dto.RolResponseDto;
import com.coudevi.application.service.IRolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rol")
@RequiredArgsConstructor
public class EquipoController {
    private final IRolService service;

    @GetMapping
    public List<RolResponseDto> listar() {
        return service.listar();
    }

    @PostMapping
    public RolResponseDto guardar(@RequestBody RolRequestDto requestDto) {
        return service.guardar(requestDto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
