package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

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
@NoArgsConstructor
public class Docente extends Persona {
    public Docente( String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String correo, String vinculacion, String departamento) {
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
    @OneToOne(mappedBy = "docente", cascade = CascadeType.ALL)
    private Direccion direccion;
    @ManyToMany(mappedBy = "docentePublicacion", fetch = FetchType.LAZY)
    private List<Publicacion> publicaciones;
}
