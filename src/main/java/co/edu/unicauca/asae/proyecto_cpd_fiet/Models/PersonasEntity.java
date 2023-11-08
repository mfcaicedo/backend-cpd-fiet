package co.edu.unicauca.asae.proyecto_cpd_fiet.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PersonasEntity {

    @Id
    private Integer idPersona;

    @Column
    private String tipoIdentificacion;
    @Column
    private String numeroIdentificacion;

    @Column
    private String nombres;
    @Column
    private String apellidos;

    @OneToOne(mappedBy = "idPersona")
    private DireccionesEntity direccion;
}
