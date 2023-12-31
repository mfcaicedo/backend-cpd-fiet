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
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.mappers.PublicacionIntMapperInfrastructureDomain;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
public class BeanConfiguration {

   //TODO apliar el BEAN para la interfaz del caso de uso GestionarPublicacion

    //van todos los bean para los diferentes casos de uso
    @Bean
    public ManagementDocenteCUAdapter createManagementDocenteCUInt
    (
            ManagementDocenteGatewayIntPort gatewayDocente,
            DocenteFormatterResultsIntPort docenteFormatterResultsIntPort
    ){
        ManagementDocenteCUAdapter gestionarDocenteCU = new ManagementDocenteCUAdapter(gatewayDocente,docenteFormatterResultsIntPort);
        return gestionarDocenteCU;
    }

    @Bean
    public ManagementPublicacionCUAdapter createManagementPublicacionCUInt(
            ManagementPublicacionGatewayIntPort gatewayPublicacion,
            ManagementDocenteGatewayIntPort gatewayDocente,
            PublicacionFormatterResultsIntPort publicacionFormatterResultsIntPort
    ){
        ManagementPublicacionCUAdapter gestionarPublicacionCU = new ManagementPublicacionCUAdapter(
                gatewayPublicacion,publicacionFormatterResultsIntPort,gatewayDocente
        );
        return gestionarPublicacionCU;
    }




    //configuracion de model mapper
    /*@Bean
    @Qualifier("docenteModelMapper")
    public ModelMapper docenteModelMapper(){
        return new ModelMapper();
    }

    @Bean
    @Qualifier("docenteModelMapperController")
    public ModelMapper docenteModelMapperConotroller(){
        return new ModelMapper();
    }

    @Bean
    @Qualifier("publicacionModelMapper")
    public ModelMapper publicacionModelMapper(){ return new ModelMapper(); }
*/


    @Bean
    public LocaleResolver localeResolver() {

        SessionLocaleResolver localResolver = new SessionLocaleResolver();
        localResolver.setDefaultLocale(Locale.US);
        return localResolver;
    }

    @Bean(name = "messageResourceSB")
    public MessageSource messageResource() {
        ResourceBundleMessageSource messageBundleResrc = new ResourceBundleMessageSource();
        messageBundleResrc.setBasename("classpath:ValidationMessages");
        messageBundleResrc.setDefaultEncoding("UTF-8");
        return messageBundleResrc;
    }
}
