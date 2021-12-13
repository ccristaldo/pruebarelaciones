package com.relaciones.prueba.dto;

/**
 *
 * @author ccristaldo
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.relaciones.prueba.converter.StringListConverter;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Convert;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmprendimientoDTO {
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
    private UsuarioDTO owner;
    
}
