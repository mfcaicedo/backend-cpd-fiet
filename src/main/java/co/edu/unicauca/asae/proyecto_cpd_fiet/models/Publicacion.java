package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publicacion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacion;
    @Column
    private String titulo;
    @Column
    private String area;
    @ManyToOne
    @JoinColumn(name="idTipo", nullable=false)
    private Tipo tipo;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "docentePublicacion", joinColumns = @JoinColumn(name = "idPublicacion"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
    private List<Docente> docentePublicacion;

}
