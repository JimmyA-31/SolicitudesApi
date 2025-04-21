package com.coudevi.application.service.impl;

import com.coudevi.application.dto.RolRequestDto;
import com.coudevi.application.dto.RolResponseDto;
import com.coudevi.application.mapper.RolMapper;
import com.coudevi.application.service.IRolService;
import com.coudevi.domain.entity.Rol;
import com.coudevi.domain.repository.IRolRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements IRolService {
    private final IRolRepository repository;
    private final RolMapper mapper;

    @Override
    public List<RolResponseDto> listar() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public RolResponseDto guardar(RolRequestDto requestDto) {
        Rol rol = mapper.toEntity(requestDto);
        return mapper.toDto(repository.save(rol));
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("El rol no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public RolResponseDto obtenerRol(Long id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("El rol no existe"));
    }
}
