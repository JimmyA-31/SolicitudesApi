package com.coudevi.web.controller;

import com.coudevi.application.dto.AreaRequestDto;
import com.coudevi.application.dto.AreaResponseDto;
import com.coudevi.application.dto.RolResponseDto;
import com.coudevi.application.service.IAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/area")
@RequiredArgsConstructor
public class AreaController {
    private final IAreaService service;

    @GetMapping
    public List<AreaResponseDto> listar() {
        return service.listar();
    }

    @PostMapping
    public AreaResponseDto guardar(@RequestBody AreaRequestDto requestDto) {
        return service.guardar(requestDto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public AreaResponseDto obtenerArea(@PathVariable Long id){
        return service.obtenerArea(id);
    }
}
