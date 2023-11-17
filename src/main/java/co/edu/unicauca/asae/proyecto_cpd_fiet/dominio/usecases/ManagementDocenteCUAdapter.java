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

        //validacion docente por correo
        Docente docenteCrear = null;
        if (this.managementDocenteGateway.validarDocentePorCorreo(docente.getCorreo())){
            this.docenteFormatterResultsIntPort
                    .retornarRespuestaErrorCorreoExiste("Error, el correo ya existe");
        }else{
            docenteCrear = this.managementDocenteGateway.create(docente);
        }

        return docenteCrear;
    }

}
