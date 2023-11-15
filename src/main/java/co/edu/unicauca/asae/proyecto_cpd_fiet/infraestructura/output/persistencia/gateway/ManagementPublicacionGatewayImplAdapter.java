package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementPublicacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementPublicacionGatewayImplAdapter implements ManagementPublicacionGatewayIntPort {
    @Override
    public boolean validPublicacionById(String id) {
        return false;
    }

    @Override
    public boolean validPublicacionByTitulo(String titulo) {
        return false;
    }

    @Override
    public Publicacion create(Publicacion publicacion) {
        return null;
    }

    @Override
    public List<Publicacion> findAll() {
        return null;
    }
}
