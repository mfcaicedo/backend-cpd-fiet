package co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.usecases;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementPublicacionCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementPublicacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.PublicacionFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;

import java.util.List;

public class ManagementPublicacionCUAdapter implements ManagementPublicacionCUIntPort {

    private final ManagementPublicacionGatewayIntPort managementPublicacionGateway;
    private final PublicacionFormatterResultsIntPort publicacionFormatterResultsIntPort;

    private final ManagementDocenteGatewayIntPort managementDocenteGatewayIntPort;


    public ManagementPublicacionCUAdapter( ManagementPublicacionGatewayIntPort managementPublicacionGateway,
                                           PublicacionFormatterResultsIntPort publicacionFormatterResultsIntPort,
                                           ManagementDocenteGatewayIntPort managementDocenteGatewayIntPort) {
        this.managementPublicacionGateway = managementPublicacionGateway;
        this.publicacionFormatterResultsIntPort = publicacionFormatterResultsIntPort;
        this.managementDocenteGatewayIntPort = managementDocenteGatewayIntPort;
    }

    @Override
    public Publicacion create(Publicacion publicacion) {
        // validar que existan los autores de la publicacion
        List<Docente> autores = publicacion.getDocentes();

        for ( Docente docente : autores ){
            if(!managementDocenteGatewayIntPort.validarDocentePorCorreo(docente.getCorreo()) || docente.getCorreo().equalsIgnoreCase("")){
                EntidadNoExisteException objException = new EntidadNoExisteException("No existe el autor" + docente.getNombres() + " para asociarlo a esta publicacion");
                throw  objException;
            }
        }

        // validar que no exista una publicacion con ese titulo
        if(this.managementPublicacionGateway.validarPublicacionByTitulo(publicacion.getTitulo())){
            EntidadYaExisteException objException = new EntidadYaExisteException("La publicación con titulo " + publicacion.getTitulo() + " ya existe");
            throw  objException;
        }


        return this.managementPublicacionGateway.create(publicacion);
    }

    @Override
    public List<Publicacion> findAll() {
        return this.managementPublicacionGateway.findAll();
    }

    @Override
    public List<PublicacionDTOResponse> consultarPublicacionPorPatron(String titulo){
        //consulta publicacion por el patron
        return this.managementPublicacionGateway.consultarPublicacionPorPatron(titulo);
    }

    @Override
    public Publicacion consultarPublicacionPorTitulo(String titulo){
        //existe ña publciacion por titulo ?
        if(this.managementPublicacionGateway.validarPublicacionByTitulo(titulo)){
            return this.managementPublicacionGateway.consultarPublicacionPorTitulo(titulo);
        }

        //no existe
        EntidadNoExisteException objException = new EntidadNoExisteException("No existe publicacion con el titulo" + titulo );
        throw  objException;

    }
    @Override
    public Publicacion asignarPublicacionDocente(String correo,String titulo){

        //existe la publicaicon y el docente ?
        if(this.managementDocenteGatewayIntPort.validarDocentePorCorreo(correo)){
            if(this.managementPublicacionGateway.validarPublicacionByTitulo(titulo)){
                //obtener publicaicon y docente y agregarlo a la lista de autores
                Publicacion publicacion = this.managementPublicacionGateway.consultarPublicacionPorTitulo(titulo);
                Docente docente = this.managementDocenteGatewayIntPort.consultarDocentePorCorreo(correo);

                publicacion.getDocentes().add(docente);

                this.managementPublicacionGateway.actualizar(publicacion);
                return publicacion;
            }else{
                EntidadNoExisteException objException = new EntidadNoExisteException("No existe publicacion con el titulo" + titulo );
                throw  objException;
            }

        }else{
            EntidadNoExisteException objException = new EntidadNoExisteException("No existe el autor" + correo + " para asociarlo a esta publicacion");
            throw  objException;
        }


    }

}
