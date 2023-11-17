package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Direccion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DireccionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteMapperImpl implements  DocenteMapperInfrastructureDomain {
    @Override
    public Docente mapperRequestToDocente(DocenteDTORequest request) {
        Direccion direccion = new Direccion(
                request.getIdPersona(),
                request.getDireccion().getDireccionResidencia(),
                request.getDireccion().getCiudad(),
                request.getDireccion().getPais()
        );
        Docente docente = new Docente(
                request.getIdPersona(), 
                request.getTipoIdentificacion(), 
                request.getNumeroIdentificacion(), request.getNombres(),
                request.getApellidos(), 
                request.getCorreo(), 
                request.getVinculacion(),
                request.getDepartamento(),
                direccion);
        direccion.setDocente(docente);
        return docente;
    }

    @Override
    public DocenteDTOResponse mapperDocenteToResponse(Docente docente) {
        return null;
    }

    @Override
    public List<DocenteDTOResponse> mapperDocentesToResponse(List<Docente> docentes) {

        List<DocenteDTOResponse> response = new ArrayList<>();
        for(int i = 0 ; i<docentes.size() ; i++){
            Docente docentePeticion = docentes.get(i);

            DocenteDTOResponse docenteMapeado = new DocenteDTOResponse();
            docenteMapeado.setIdPersona(docentePeticion.getIdPersona());
            docenteMapeado.setTipoIdentificacion(docentePeticion.getTipoIdentificacion());
            docenteMapeado.setNumeroIdentificacion(docentePeticion.getNumeroIdentificacion());
            docenteMapeado.setVinculacion(docentePeticion.getVinculacion());
            docenteMapeado.setDepartamento(docentePeticion.getDepartamento());
            docenteMapeado.setNombres(docentePeticion.getNombres());
            docenteMapeado.setApellidos(docentePeticion.getApellidos());
            docenteMapeado.setCorreo(docentePeticion.getCorreo());

            DireccionDTOResponse direccionMapeada = new DireccionDTOResponse();
            direccionMapeada.setIdPersona(docentePeticion.getIdPersona());
            direccionMapeada.setDireccionResidencia(docentePeticion.getDireccion().getDireccionResidencia());
            direccionMapeada.setCiudad(docentePeticion.getDireccion().getCiudad());
            direccionMapeada.setPais(docentePeticion.getDireccion().getPais());
            docenteMapeado.setDireccion(direccionMapeada);

            response.add(docenteMapeado);
        }
        return response;
    }

    @Override
    public List<Docente> mapperDocentesRequestToDocente(List<DocenteDTORequest> docentes) {
        List<Docente> response = new ArrayList<>();
        for(DocenteDTORequest docenteRequest : docentes){
            Docente docenteMapeado = this.mapperRequestToDocente(docenteRequest);



            response.add(docenteMapeado);
        }
        return response;
    }
}
