package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "docente")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DocenteEntity extends PersonaEntity {
    public DocenteEntity(String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String correo, String vinculacion, String departamento) {
        super( tipoIdentificacion, numeroIdentificacion, nombres, apellidos);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
    }
    @Column
    private String correo;
    @Column
    private String vinculacion;
    @Column
    private String departamento;
    @OneToOne(mappedBy = "docenteEntity", cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private DireccionEntity direccionEntity;
    @JsonIgnore
    @ManyToMany(mappedBy = "docentes", fetch = FetchType.EAGER)
    private List<PublicacionEntity> publicaciones;
}
