package com.relaciones.prueba.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.relaciones.prueba.converter.StringListConverter;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ccristaldo
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class EmprendimientoEntity {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String contenido;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaCreado;
    private Long objetivo;
    private boolean publicado;
    @Convert(converter = StringListConverter.class)
    private List<String> capturas;
    @Convert(converter = StringListConverter.class)
    private List<String> tags;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private UsuarioEntity owner;

    public boolean isPublicado(boolean publicado) {
       return publicado; 
    }
    
    public UsuarioEntity getOwner() {
        return owner;
    }

    public void setOwner(UsuarioEntity owner) {
        this.owner = owner;
    }
}
