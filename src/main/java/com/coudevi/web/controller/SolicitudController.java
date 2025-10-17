package com.coudevi.web.controller;

import com.coudevi.application.dto.SolicitudRequestDto;
import com.coudevi.application.dto.SolicitudResponseDto;
import com.coudevi.application.service.ISolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitud")
@RequiredArgsConstructor
public class SolicitudController {
    private final ISolicitudService service;

    @GetMapping
    public List<SolicitudResponseDto> listar(){
        return service.listar();
    }

    @PostMapping
    public SolicitudResponseDto guardar(@RequestBody SolicitudRequestDto requestDto){
        return service.guardar(requestDto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }

    @GetMapping("/{id}")
    public SolicitudResponseDto obtenerSolicitud(@PathVariable Long id){
        return service.obtenerSolicitud(id);
    }
}
