package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DocenteMapper {
    @Bean
    public ModelMapper crearDocenteMapper() {
        return new ModelMapper();
    }
}
