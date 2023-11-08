package co.edu.unicauca.asae.proyecto_cpd_fiet.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "direcciones")
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
