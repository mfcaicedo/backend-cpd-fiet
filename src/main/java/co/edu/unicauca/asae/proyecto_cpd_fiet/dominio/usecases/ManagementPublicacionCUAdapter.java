package co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.usecases;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementPublicacionCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementPublicacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.PublicacionFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;

import java.util.List;

public class ManagementPublicacionCUAdapter implements ManagementPublicacionCUIntPort {

    private final ManagementPublicacionGatewayIntPort managementPublicacionGateway;
    private final PublicacionFormatterResultsIntPort publicacionFormatterResultsIntPort;

    public ManagementPublicacionCUAdapter( ManagementPublicacionGatewayIntPort managementPublicacionGateway,
                                           PublicacionFormatterResultsIntPort publicacionFormatterResultsIntPort) {
        this.managementPublicacionGateway = managementPublicacionGateway;
        this.publicacionFormatterResultsIntPort = publicacionFormatterResultsIntPort;
    }

    @Override
    public Publicacion create(Publicacion publicacion) {
        return this.managementPublicacionGateway.create(publicacion);
    }

    @Override
    public List<Publicacion> findAll() {
        return this.managementPublicacionGateway.findAll();
    }
}
