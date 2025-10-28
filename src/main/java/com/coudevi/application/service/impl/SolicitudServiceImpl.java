package com.coudevi.application.service.impl;

import com.coudevi.application.dto.SolicitudRequestDto;
import com.coudevi.application.dto.SolicitudResponseDto;
import com.coudevi.application.dto.UsuarioResponseDto;
import com.coudevi.application.mapper.SolicitudMapper;
import com.coudevi.application.mapper.UsuarioMapper;
import com.coudevi.application.service.ISolicitudService;
import com.coudevi.domain.entity.Area;
import com.coudevi.domain.entity.Rol;
import com.coudevi.domain.entity.Solicitud;
import com.coudevi.domain.entity.Usuario;
import com.coudevi.domain.repository.ISolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements ISolicitudService {

    private final ISolicitudRepository repository;
    private final SolicitudMapper mapper;
    private final UsuarioServiceImpl serviceUsuario;
    private final UsuarioMapper mapperUsuario;


    @Override
    public List<SolicitudResponseDto> listar() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @Override
    public SolicitudResponseDto guardar(SolicitudRequestDto requestDto) {
        UsuarioResponseDto usuarioResponseDto = serviceUsuario.obtenerUsuario(requestDto.getIdUsuario());
        Usuario usuario = mapperUsuario.toEntityUsuario(usuarioResponseDto);

        Solicitud solicitud = mapper.toEntity(requestDto, usuario);

        return  mapper.toDto(repository.save(solicitud));
    }

    @Override
    public void eliminar(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("No existe la solicitud con el ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public SolicitudResponseDto obtenerSolicitud(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("No hay solicitud con el id : " + id));
    }

    @Override
    public SolicitudResponseDto actualizar(SolicitudRequestDto requestDto) {
// 1️⃣ Verificar existencia
        if (!repository.existsById(requestDto.getId())) {
            throw new RuntimeException("No existe la solicitud con el ID: " + requestDto.getId());
        }

        // 2️⃣ Obtener usuario
        UsuarioResponseDto usuarioResponseDto = serviceUsuario.obtenerUsuario(requestDto.getIdUsuario());
        Usuario usuario = mapperUsuario.toEntityUsuario(usuarioResponseDto);

        // 3️⃣ Mapear el DTO a entidad (ya con los datos actualizados)
        Solicitud solicitudActualizada = mapper.toEntity(requestDto, usuario);
        solicitudActualizada.setId(requestDto.getId()); // aseguramos que tenga el ID correcto

        // 4️⃣ Guardar y retornar
        return mapper.toDto(repository.save(solicitudActualizada));
    }
    }

