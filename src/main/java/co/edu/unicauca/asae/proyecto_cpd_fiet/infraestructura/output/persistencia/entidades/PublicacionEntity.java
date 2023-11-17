package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PublicacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacion;
    @Column
    private String titulo;
    @Column
    private String area;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idTipo", nullable=false)
    private TipoEntity tipo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "docenteEntityPublicacion", joinColumns = @JoinColumn(name = "idPublicacion"), inverseJoinColumns = @JoinColumn(name = "idPersona"))
    private List<DocenteEntity> docentes;

}
