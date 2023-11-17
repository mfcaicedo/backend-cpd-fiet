package co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;

import java.util.List;

public interface ManagementPublicacionGatewayIntPort {

    public boolean validarPublicacionById(String id);
    public boolean validarPublicacionByTitulo(String titulo);
    public Publicacion create(Publicacion publicacion);
    public Publicacion actualizar(Publicacion publicacion);
    public List<Publicacion> findAll();
    public List<PublicacionDTOResponse> consultarPublicacionPorPatron(String titulo);
    public Publicacion consultarPublicacionPorTitulo(String titulo);
    public Publicacion asignarPublicacionDocente(String correo,String titulo);

}
