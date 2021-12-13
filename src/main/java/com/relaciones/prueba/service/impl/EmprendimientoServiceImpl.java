package com.relaciones.prueba.service.impl;

import com.relaciones.prueba.dto.EmprendimientoDTO;
import com.relaciones.prueba.entity.EmprendimientoEntity;
import com.relaciones.prueba.mapper.EmprendimientoMapper;
import com.relaciones.prueba.repository.EmprendimientoRepository;
import com.relaciones.prueba.service.EmprendimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ccristaldo
 */
@Service
public class EmprendimientoServiceImpl implements EmprendimientoService{
    @Autowired
    private EmprendimientoMapper emprendimientoMapper;
    @Autowired
    private EmprendimientoRepository emprendimientoRepository;

    @Override
    public EmprendimientoDTO save(EmprendimientoDTO emprendimientoDTO) {
        EmprendimientoEntity entity = emprendimientoMapper.emprendimientoDTO2Entity(emprendimientoDTO);
        EmprendimientoEntity emprendimientoSaved = emprendimientoRepository.save(entity);
        EmprendimientoDTO result = emprendimientoMapper.emprendimientoEntity2DTO(emprendimientoSaved);
        return result;
    }

    
}
