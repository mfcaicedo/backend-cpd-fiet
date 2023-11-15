package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "docente")
@Getter
@Setter
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
    @OneToOne(mappedBy = "docenteEntity", cascade = CascadeType.ALL)
    private DireccionEntity direccionEntity;
    @ManyToMany(mappedBy = "docenteEntityPublicacion", fetch = FetchType.LAZY)
    private List<PublicacionEntity> publicaciones;
}