package com.relaciones.prueba.entity;

import com.relaciones.prueba.enums.TipoUsuario;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
/**
 *
 * @author ccristaldo
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmprendimientoEntity> emprendimientos = new ArrayList<>();

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nombre, String apellido, String email, String password, LocalDate fechaCreacion, String ciudad, String provincia, String pais, TipoUsuario tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
        this.tipo = tipo;
    }
    
    
    
    public void agregarEmprendimiento(EmprendimientoEntity emprendimiento){
        emprendimientos.add(emprendimiento);
        emprendimiento.setOwner(this);
    }
    
    public void removerEmprendimiento(EmprendimientoEntity emprendimiento){
        emprendimientos.remove(emprendimiento);
        emprendimiento.setOwner(null);
    }
    
}
