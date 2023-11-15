package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.configuracion;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.DocenteFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementPublicacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.PublicacionFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.usecases.ManagementDocenteCUAdapter;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.usecases.ManagementPublicacionCUAdapter;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfrastructureDomain;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.mappers.PublicacionMapperInfrastructureDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BeanConfiguration {

   //TODO apliar el BEAN para la interfaz del caso de uso GestionarPublicacion

    //van todos los bean para los diferentes casos de uso
    @Bean
    public ManagementDocenteCUAdapter createManagementDocenteCUInt(
            ManagementDocenteGatewayIntPort managementDocenteGatewayIntPort,
            DocenteFormatterResultsIntPort docenteFormatterResultsIntPort) {
        ManagementDocenteCUAdapter managementDocenteCUAdapter = new ManagementDocenteCUAdapter(
                managementDocenteGatewayIntPort, docenteFormatterResultsIntPort);
        return managementDocenteCUAdapter;
    }

    @Bean
    public ManagementPublicacionCUAdapter createManagementPublicacionCUInt(
            ManagementPublicacionGatewayIntPort managementPublicacionGatewayIntPort,
            PublicacionFormatterResultsIntPort publicacionFormatterResultsIntPort) {
        ManagementPublicacionCUAdapter managementPublicacionCUAdapter = new ManagementPublicacionCUAdapter(
                managementPublicacionGatewayIntPort, publicacionFormatterResultsIntPort);
        return managementPublicacionCUAdapter;
    }

    //configuracion de model mapper
    @Bean
    @Qualifier("docenteModelMapper")
    public ModelMapper docenteModelMapper(){
        return new ModelMapper();
    }

    @Bean
    @Qualifier("publicacionModelMapper")
    public ModelMapper publicacionModelMapper(){ return new ModelMapper(); }

    @Bean
    public PublicacionMapperInfrastructureDomain publicacionMapperInfrastructureDomain(){
        return new PublicacionMapperInfrastructureDomain() {
            @Override
            public Publicacion mapperRequestToPublicacion(PublicacionDTORequest request) {
                return null;
            }

            @Override
            public PublicacionDTOResponse mapperPublicacionToResponse(Publicacion publicacion) {
                return null;
            }

            @Override
            public List<PublicacionDTOResponse> mapperPublicacionesToResponse(List<Publicacion> publicaciones) {
                return null;
            }
        };
    }
    @Bean
    public DocenteMapperInfrastructureDomain docenteMapperInfrastructureDomain() {
        return new DocenteMapperInfrastructureDomain() {
            @Override
            public Docente mapperRequestToDocente(DocenteDTORequest request) {
                return null;
            }
            @Override
            public DocenteDTOResponse mapperDocenteToResponse(Docente docente) {
                return null;
            }
            @Override
            public List<DocenteDTOResponse> mapperDocentesToResponse(List<Docente> docentes) {
                return null;
            }
        };
    }
}
