package com.relaciones.prueba.repository;

import com.relaciones.prueba.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ccristaldo
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    
}
