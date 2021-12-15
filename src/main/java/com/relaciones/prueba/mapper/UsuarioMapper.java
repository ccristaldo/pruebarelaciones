package com.relaciones.prueba.mapper;

import com.relaciones.prueba.dto.UsuarioDTO;
import com.relaciones.prueba.entity.UsuarioEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
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
                .fechaCreacion(LocalDate.now())
                .emprendimientos(dto.getEmprendimientos())
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
                .emprendimientos(entity.getEmprendimientos())
                .build();
    }
    
    public List<UsuarioEntity> listUsuarioDTO2Entity(List<UsuarioDTO> dtos){
        return dtos.stream().map(a -> usuarioDTO2Entity(a)).collect(Collectors.toList());
    }
    
    public List<UsuarioDTO> listUsuarioEntity2DTO(List<UsuarioEntity> entities){
        return entities.stream().map(a -> usuarioEntity2DTO(a)).collect(Collectors.toList());
    }

}
