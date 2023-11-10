package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    @Id
    @Column(name = "idPersona")
    private Integer idPersona;
    @Column
    private String direccionResidencia;
    @Column
    private String ciudad;
    @Column
    private String pais;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name="idPersona")
    private Docente docente;

}
