package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.formateador;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.DocenteFormatterResultsIntPort;
import org.springframework.stereotype.Service;

@Service
public class DocenteFormateadorResultadosImplAdapter implements DocenteFormatterResultsIntPort {

    @Override
    public void retornarRespuestaErrorEntidadExiste(String mensaje){
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    @Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje){
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }
}
