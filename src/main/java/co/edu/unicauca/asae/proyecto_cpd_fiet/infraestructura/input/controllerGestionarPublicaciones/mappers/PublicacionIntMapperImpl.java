package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.mappers;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Tipo;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfrastructureDomain;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.TipoDTOResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublicacionIntMapperImpl implements PublicacionIntMapperInfrastructureDomain {
    private final DocenteMapperInfrastructureDomain docenteMapper;

    public PublicacionIntMapperImpl(DocenteMapperInfrastructureDomain docenteMapper) {
        this.docenteMapper = docenteMapper;
    }

    @Override
    public Publicacion mapperRequestToPublicacion(PublicacionDTORequest request) {
        Publicacion publicacionMapeada = new Publicacion();
        Tipo tipo = new Tipo();
        tipo.setIdTipo(request.getTipo().getIdTipo());
        tipo.setNombre(request.getTipo().getNombre());
        publicacionMapeada.setIdPublicacion(request.getIdPublicacion());
        publicacionMapeada.setTitulo(request.getTitulo());
        publicacionMapeada.setArea(request.getArea());
        publicacionMapeada.setTipo(tipo);

        publicacionMapeada.setDocentes( this.docenteMapper.mapperDocentesRequestToDocente(request.getDocentes()));
        return publicacionMapeada;
    }

    @Override
    public PublicacionDTOResponse mapperPublicacionToResponse(Publicacion publicacion) {

        PublicacionDTOResponse response = new PublicacionDTOResponse();
        response.setIdPublicacion(publicacion.getIdPublicacion());
        response.setArea(publicacion.getArea());
        response.setTitulo(publicacion.getTitulo());
        response.setDocentes( this.docenteMapper.mapperDocentesToResponse(publicacion.getDocentes()));

        TipoDTOResponse tipoMapeado = new TipoDTOResponse();
        tipoMapeado.setIdTipo(publicacion.getTipo().getIdTipo());
        tipoMapeado.setNombre(publicacion.getTipo().getNombre());
        response.setTipo(tipoMapeado);
        return response;
    }

    @Override
    public List<PublicacionDTOResponse> mapperPublicacionesToResponse(List<Publicacion> publicaciones) {

        List<PublicacionDTOResponse> publicacionesMapeadas = new ArrayList<>();
        for(Publicacion publicacion : publicaciones){
            PublicacionDTOResponse publicacionMapeada = this.mapperPublicacionToResponse(publicacion);
            publicacionesMapeadas.add(publicacionMapeada);

        }
        return publicacionesMapeadas;
    }
}
