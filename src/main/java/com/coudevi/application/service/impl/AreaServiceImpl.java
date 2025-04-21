package com.coudevi.application.service.impl;

import com.coudevi.application.dto.AreaRequestDto;
import com.coudevi.application.dto.AreaResponseDto;
import com.coudevi.application.mapper.AreaMapper;
import com.coudevi.application.service.IAreaService;
import com.coudevi.domain.entity.Area;
import com.coudevi.domain.repository.IAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AreaServiceImpl implements IAreaService {
    private final IAreaRepository repository;
    private final AreaMapper mapper;

    @Override
    public List<AreaResponseDto> listar() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public AreaResponseDto guardar(AreaRequestDto requestDto) {
        Area area = mapper.toEntity(requestDto);
        return mapper.toDto(repository.save(area));
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("El area no existe");
        }
        repository.deleteById(id);
    }

    @Override
    public AreaResponseDto obtenerArea(Long id) {
        return repository.findById(id).map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("El area no existe"));
    }
}
