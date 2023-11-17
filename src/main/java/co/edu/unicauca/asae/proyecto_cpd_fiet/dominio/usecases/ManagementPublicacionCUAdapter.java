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

        List<Docente> autores = publicacion.getDocentes();
        if(!autores.isEmpty()){
            for ( Docente docente : autores ){
                if(!managementDocenteGatewayIntPort.validarDocentePorCorreo(docente.getCorreo()) || docente.getCorreo().equalsIgnoreCase("")){
                    EntidadNoExisteException objException = new EntidadNoExisteException("No existe el autor" + docente.getNombres() + " para asociarlo a esta publicacion");
                    throw  objException;
                }
            }
        }


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
        return this.managementPublicacionGateway.consultarPublicacionPorPatron(titulo);
    }

    @Override
    public Publicacion consultarPublicacionPorTitulo(String titulo){

        if(this.managementPublicacionGateway.validarPublicacionByTitulo(titulo)){
            return this.managementPublicacionGateway.consultarPublicacionPorTitulo(titulo);
        }

        EntidadNoExisteException objException = new EntidadNoExisteException("No existe publicacion con el titulo" + titulo );
        throw  objException;

    }
    @Override
    public Publicacion asignarPublicacionDocente(String correo,String titulo){

        //existe la publicaicon y el docente ?
        if(this.managementDocenteGatewayIntPort.validarDocentePorCorreo(correo)){
            if(this.managementPublicacionGateway.validarPublicacionByTitulo(titulo)){
                System.out.println("#Existe publicaicon y autores");
                //obtener publicaicon y docente y agregarlo a la lista de autores
                Publicacion publicacion = this.managementPublicacionGateway.consultarPublicacionPorTitulo(titulo);
                System.out.println("PUBLICACION ES "+ publicacion.toString());
                Docente docente = this.managementDocenteGatewayIntPort.consultarDocentePorCorreo(correo);

                publicacion.getDocentes().add(docente);
                System.out.println(publicacion.getDocentes().get(0).getIdPersona());


                return this.managementPublicacionGateway.create(publicacion);
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
