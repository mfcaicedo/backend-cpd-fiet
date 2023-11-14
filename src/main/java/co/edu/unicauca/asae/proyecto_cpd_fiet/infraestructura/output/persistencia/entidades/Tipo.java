package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "tipo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipo;
    @Column
    private String nombre;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "tipo")
    private List<Publicacion> publicacions;

}
