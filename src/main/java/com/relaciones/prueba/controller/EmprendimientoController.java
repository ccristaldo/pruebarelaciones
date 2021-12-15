package com.relaciones.prueba.controller;

import com.relaciones.prueba.dto.EmprendimientoDTO;
import com.relaciones.prueba.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class EmprendimientoController {
    
    @Autowired
    private EmprendimientoService emprendimientoService;
    
    @PostMapping("emprendimientos")
    public ResponseEntity<EmprendimientoDTO> save(@RequestBody EmprendimientoDTO emprendimientoDTO){
        EmprendimientoDTO emprendimientoSaved = emprendimientoService.save(emprendimientoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(emprendimientoSaved);
    }
    
    @GetMapping("emprendimientos/{id}")
    public ResponseEntity<EmprendimientoDTO> getEmprendimientoById(@PathVariable Long id){
        EmprendimientoDTO emprendimientoDTO = emprendimientoService.getById(id);
        return ResponseEntity.ok(emprendimientoDTO);
    }
            
            
  
}
