package com.relaciones.prueba.repository;

import com.relaciones.prueba.entity.EmprendimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ccristaldo
 */
@Repository
public interface EmprendimientoRepository extends JpaRepository<EmprendimientoEntity, Long>{
    
}
