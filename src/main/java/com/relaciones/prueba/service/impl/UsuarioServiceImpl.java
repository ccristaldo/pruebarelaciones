package com.relaciones.prueba.service.impl;

import com.relaciones.prueba.dto.UsuarioDTO;
import com.relaciones.prueba.entity.UsuarioEntity;
import com.relaciones.prueba.mapper.UsuarioMapper;
import com.relaciones.prueba.repository.UsuarioRepository;
import com.relaciones.prueba.service.UsuarioService;
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
    
}


