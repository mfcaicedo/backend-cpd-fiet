package co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;

import java.util.List;

public interface ManagementDocenteGatewayIntPort {

    public boolean validarDocentePorCorreo(String correo);
    public Docente create(Docente docente);
    public Docente consultarDocentePorCorreo(String correo);

    List<Docente> findAll();
}
