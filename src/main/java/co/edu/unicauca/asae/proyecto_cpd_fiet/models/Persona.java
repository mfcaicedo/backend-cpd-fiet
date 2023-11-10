package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;
    @Column
    private String tipoIdentificacion;
    @Column
    private String numeroIdentificacion;
    @Column
    private String nombres;
    @Column
    private String apellidos;

}
