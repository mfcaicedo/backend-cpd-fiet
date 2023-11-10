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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDireccion")
    private Integer idDireccion;
    @Column
    private String direccionResidencia;
    @Column
    private String ciudad;
    @Column
    private String pais;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Docente docente;

}
