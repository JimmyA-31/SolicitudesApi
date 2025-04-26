package com.coudevi.application.service.impl;

import com.coudevi.application.dto.AreaResponseDto;
import com.coudevi.application.dto.RolResponseDto;
import com.coudevi.application.dto.UsuarioRequestDto;
import com.coudevi.application.dto.UsuarioResponseDto;
import com.coudevi.application.mapper.AreaMapper;
import com.coudevi.application.mapper.RolMapper;
import com.coudevi.application.mapper.UsuarioMapper;
import com.coudevi.application.service.IUsuarioService;
import com.coudevi.domain.entity.Area;
import com.coudevi.domain.entity.Rol;
import com.coudevi.domain.entity.Usuario;
import com.coudevi.domain.repository.IUsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IUsuarioService {
    private final IUsuarioRepository repository;
    private final UsuarioMapper mapper;
    private final RolServiceImpl rolService;
    private final RolMapper rolMapper;
    private final AreaServiceImpl areaService;
    private final AreaMapper areaMapper;

    @Override
    public List<UsuarioResponseDto> listar() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public UsuarioResponseDto guardar(UsuarioRequestDto requestDto) {
        RolResponseDto rolResponseDto = rolService.obtenerRol(requestDto.getIdRol());
        Rol rol = rolMapper.toEntityRol(rolResponseDto);

        AreaResponseDto areaResponseDto = areaService.obtenerArea(requestDto.getIdArea());
        Area area = areaMapper.toEntityArea(areaResponseDto);

        Usuario usuario = mapper.toEntity(requestDto, rol, area);

        return mapper.toDto(repository.save(usuario));
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe el usuario con el ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public UsuarioResponseDto obtenerUsuario(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("No hay usuarios con el id : " + id));
    }
}
