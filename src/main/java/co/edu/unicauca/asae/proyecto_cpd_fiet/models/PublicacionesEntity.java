package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "publicaciones")
public class PublicacionesEntity {
    @Id
    private Integer idPublicacion;

    @Column
    private Integer idTipo;
    @Column
    private String titulo;
    @Column
    private String area;
}
