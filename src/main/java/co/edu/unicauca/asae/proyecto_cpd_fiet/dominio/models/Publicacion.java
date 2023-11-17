package co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.TipoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publicacion {

    private Integer idPublicacion;
    private String titulo;
    private String area;
    private Tipo tipo;
    private List<Docente> docentes;

}
