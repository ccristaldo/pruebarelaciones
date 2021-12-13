package com.relaciones.prueba.service.impl;

import com.relaciones.prueba.dto.UsuarioDTO;
import com.relaciones.prueba.entity.UsuarioEntity;
import com.relaciones.prueba.mapper.UsuarioMapper;
import com.relaciones.prueba.repository.UsuarioRepository;
import com.relaciones.prueba.service.UsuarioService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ccristaldo
 */
@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private UsuarioMapper usuarioMapper;
    
    @Override
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        UsuarioEntity entity = usuarioMapper.usuarioDTO2Entity(usuarioDTO);
        UsuarioEntity usuarioSaved = usuarioRepository.save(entity);
        UsuarioDTO result = usuarioMapper.usuarioEntity2DTO(usuarioSaved);
        System.out.println("USUARIO GUARDADO");
        return result;
    }

    @Override
    public UsuarioDTO getById(Long id) {
        Optional<UsuarioEntity> entity = usuarioRepository.findById(id);
        if (!entity.isPresent()){
            System.out.println("id inexistente");
        }
        UsuarioDTO result = usuarioMapper.usuarioEntity2DTO(entity.get());
        return result;    
    }
    
    @Transactional
    @Override
    public List<UsuarioDTO> getAll() {
        List<UsuarioEntity> entities = usuarioRepository.findAll();
        List<UsuarioDTO> dtos = usuarioMapper.listUsuarioEntity2DTO(entities);
        return dtos;
    }
   
}


