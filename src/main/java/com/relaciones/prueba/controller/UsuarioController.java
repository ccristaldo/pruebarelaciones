package com.relaciones.prueba.controller;

import com.relaciones.prueba.dto.UsuarioDTO;
import com.relaciones.prueba.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ccristaldo
 */
@RestController
@RequestMapping("/api")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @PostMapping("usuarios")
    public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuarioDTO){
        UsuarioDTO usuarioSaved = usuarioService.save(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSaved);
    }
    
}
