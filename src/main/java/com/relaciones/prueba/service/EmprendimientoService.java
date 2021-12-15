package com.relaciones.prueba.service;

import com.relaciones.prueba.dto.EmprendimientoDTO;

/**
 *
 * @author ccristaldo
 */
public interface EmprendimientoService {

    public EmprendimientoDTO save(EmprendimientoDTO emprendimientoDTO);

    public EmprendimientoDTO getById(Long id);
    
}
