package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "direcciones")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DireccionesEntity {

    @Id
    @GeneratedValue
    private Integer idDireccion;

    @OneToOne
    @JoinColumn(name = "idPersona")
    private PersonasEntity idPersona;
    @Column
    private String direccionResidencia;

    @Column
    private String ciudad;

    @Column
    private String pais;
}
