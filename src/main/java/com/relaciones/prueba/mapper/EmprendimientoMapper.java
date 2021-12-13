package com.relaciones.prueba.mapper;

import com.relaciones.prueba.dto.EmprendimientoDTO;
import com.relaciones.prueba.entity.EmprendimientoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ccristaldo
 */
@Component
public class EmprendimientoMapper {
    
    @Autowired
    private UsuarioMapper usuarioMapper;

    public EmprendimientoEntity emprendimientoDTO2Entity(EmprendimientoDTO dto) {
        return EmprendimientoEntity.builder()
                .nombre(dto.getNombre())
                .objetivo(dto.getObjetivo())
                .descripcion(dto.getDescripcion())
                .contenido(dto.getContenido())
                .capturas(dto.getCapturas())
                .tags(dto.getTags())
                .owner(usuarioMapper.usuarioDTO2Entity(dto.getOwner()))
                .build();
    }
    
    public EmprendimientoDTO emprendimientoEntity2DTO(EmprendimientoEntity entity) {
        return EmprendimientoDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .objetivo(entity.getObjetivo())
                .descripcion(entity.getDescripcion())
                .contenido(entity.getContenido())
                .capturas(entity.getCapturas())
                .tags(entity.getTags())
                .owner(usuarioMapper.usuarioEntity2DTO(entity.getOwner()))
                .build();
    }
    
}
