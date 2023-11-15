package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;

import java.util.List;

public interface DocenteMapperInfrastructureDomain {

    Docente mapperRequestToDocente(DocenteDTORequest request);
    DocenteDTOResponse mapperDocenteToResponse(Docente docente);
    List<DocenteDTOResponse> mapperDocentesToResponse(List<Docente> docentes);

}
