package co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipo {
    private Integer idTipo;
    private String nombre;
    private List<PublicacionEntity> publicacionEntities;
}
