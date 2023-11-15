package co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;

public interface ManagementDocenteGatewayIntPort {

    public boolean validProducctoByCodigo(String codigo);
    public Docente create(Docente docente);

}
