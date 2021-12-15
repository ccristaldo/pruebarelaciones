package com.relaciones.prueba.service;

import com.relaciones.prueba.dto.UsuarioDTO;
import java.util.List;

/**
 *
 * @author ccristaldo
 */
public interface UsuarioService {

        public UsuarioDTO save(UsuarioDTO usuarioDTO);
        
        public UsuarioDTO getById(Long id);

    public List<UsuarioDTO> getAll();
    
}
