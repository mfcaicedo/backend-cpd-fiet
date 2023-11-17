package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.mappers;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;

import java.util.List;

public interface PublicacionIntMapperInfrastructureDomain {
    Publicacion mapperRequestToPublicacion(PublicacionDTORequest request);
    PublicacionDTOResponse mapperPublicacionToResponse(Publicacion publicacion);
    List<PublicacionDTOResponse> mapperPublicacionesToResponse(List<Publicacion> publicaciones);
}
