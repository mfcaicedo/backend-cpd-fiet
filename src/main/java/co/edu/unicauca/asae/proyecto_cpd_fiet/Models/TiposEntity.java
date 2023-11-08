package co.edu.unicauca.asae.proyecto_cpd_fiet.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter@Setter
@AllArgsConstructor
@Entity
@Table(name = "tipos")
public class TiposEntity {
    @Id
    private Integer idTipo;

    @Column
    private String nombre;
}
