package co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;

import java.util.List;

public interface ManagementPublicacionGatewayIntPort {

    public boolean validPublicacionById(String id);
    public boolean validPublicacionByTitulo(String titulo);
    public Publicacion create(Publicacion publicacion);
    public List<Publicacion> findAll();

}
