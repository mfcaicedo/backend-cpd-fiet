package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.configuracion;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.DocenteFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.usecases.ManagementDocenteCUAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
