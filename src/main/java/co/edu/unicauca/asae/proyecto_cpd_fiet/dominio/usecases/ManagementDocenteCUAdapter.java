package co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.usecases;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.DocenteFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;

public class ManagementDocenteCUAdapter implements ManagementDocenteCUIntPort {

    private final ManagementDocenteGatewayIntPort managementDocenteGateway;
    private final DocenteFormatterResultsIntPort docenteFormatterResultsIntPort;

    public ManagementDocenteCUAdapter(ManagementDocenteGatewayIntPort managementDocenteGateway,
            DocenteFormatterResultsIntPort docenteFormatterResultsIntPort) {
        this.managementDocenteGateway = managementDocenteGateway;
        this.docenteFormatterResultsIntPort = docenteFormatterResultsIntPort;
    }

    @Override
    public Docente create(Docente docente) {
        return this.managementDocenteGateway.create(docente);
    }

}
