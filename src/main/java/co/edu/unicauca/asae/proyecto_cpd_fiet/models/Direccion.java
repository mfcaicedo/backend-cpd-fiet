package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "direcciones")
@Getter
@Setter
@ToString
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPersona;

   /* @Column
    private Integer idPersona;
*/

    @Column
    private String direccionResidencia;
    @Column
    private String ciudad;
    @Column
    private String pais;

    @OneToOne
    @JoinColumn(name = "idPersona" ) // especifica la columna referenciada , referencedColumnName = "idPersona"
    private Docente docente;


    public Direccion() {
    }
}
