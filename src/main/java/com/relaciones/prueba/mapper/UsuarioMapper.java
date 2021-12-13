package com.relaciones.prueba.mapper;

import com.relaciones.prueba.dto.UsuarioDTO;
import com.relaciones.prueba.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author ccristaldo
 */
@Component
public class UsuarioMapper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioEntity usuarioDTO2Entity(UsuarioDTO dto) {
        return UsuarioEntity.builder()
                .nombre(dto.getNombre())
                .apellido(dto.getApellido())
                .ciudad(dto.getCiudad())
                .provincia(dto.getProvincia())
                .pais(dto.getPais())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .tipo(dto.getTipo())
                .fechaCreacion(dto.getFechaCreacion())
                .build();
    }
    
    public UsuarioDTO usuarioEntity2DTO(UsuarioEntity entity) {
        return UsuarioDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .apellido(entity.getApellido())
                .ciudad(entity.getCiudad())
                .provincia(entity.getProvincia())
                .pais(entity.getPais())
                .email(entity.getEmail())
                .password(passwordEncoder.encode(entity.getPassword()))
                .tipo(entity.getTipo())
                .fechaCreacion(entity.getFechaCreacion())
                .build();
    }
    
}
