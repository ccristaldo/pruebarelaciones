package com.relaciones.prueba.dto;

/**
 *
 * @author ccristaldo
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import com.relaciones.prueba.entity.EmprendimientoEntity;
import com.relaciones.prueba.enums.TipoUsuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    @Column(unique = true, length = 32)
    @Email
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDate fechaCreacion;
    private String ciudad;
    private String provincia;
    private String pais;
    @Enumerated(value = EnumType.STRING)
    private TipoUsuario tipo;
    private boolean deleted = Boolean.FALSE;
    private List<EmprendimientoEntity> emprendimientos = new ArrayList<>();
    
}
