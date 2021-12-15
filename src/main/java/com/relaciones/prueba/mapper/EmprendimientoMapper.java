package com.relaciones.prueba.mapper;

import com.relaciones.prueba.dto.EmprendimientoDTO;
import com.relaciones.prueba.entity.EmprendimientoEntity;
import com.relaciones.prueba.entity.UsuarioEntity;
import com.relaciones.prueba.repository.UsuarioRepository;
import com.relaciones.prueba.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ccristaldo
 */
@Component
public class EmprendimientoMapper {
    
    @Autowired
    private  UsuarioMapper usuarioMapper;
    
    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private  UsuarioRepository usuarioRepository;

    public EmprendimientoEntity emprendimientoDTO2Entity(EmprendimientoDTO dto) {
        UsuarioEntity duenio = usuarioRepository.findById(dto.getOwnerId()).orElseThrow(() -> new EntityNotFoundException("Usuario No Encontrado"));
        //UsuarioEntity duenio = usuarioMapper.usuarioDTO2Entity(usuarioService.getById(dto.getOwnerId()));
        return EmprendimientoEntity.builder()
                .nombre(dto.getNombre())
                .objetivo(dto.getObjetivo())
                .descripcion(dto.getDescripcion())
                .contenido(dto.getContenido())
                .capturas(dto.getCapturas())
                .tags(dto.getTags())
                .fechaCreado(dto.getFechaCreado())
                .owner(duenio)//encontrar usuario de getownerid
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
                .fechaCreado(entity.getFechaCreado())
                .ownerId(entity.getOwner().getId())
                .build();
    }
    
    public List<EmprendimientoEntity> listEmprendimientoDTO2Entity(List<EmprendimientoDTO> dtos){
        return dtos.stream().map(a -> emprendimientoDTO2Entity(a)).collect(Collectors.toList());
    }
    
    public List<EmprendimientoDTO> listEmprendimientoEntity2DTO(List<EmprendimientoEntity> entities){
        return entities.stream().map(a -> emprendimientoEntity2DTO(a)).collect(Collectors.toList());
    }
    
    
}
