package co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;

import java.util.List;

public interface ManagementDocenteCUIntPort {

    Docente create(Docente docente);

    List<Docente> findAll();

}
