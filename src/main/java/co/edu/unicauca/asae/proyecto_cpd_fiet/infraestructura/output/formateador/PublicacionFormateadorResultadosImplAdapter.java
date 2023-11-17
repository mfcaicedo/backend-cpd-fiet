package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.formateador;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.DocenteFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.PublicacionFormatterResultsIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import org.springframework.stereotype.Service;

@Service
public class PublicacionFormateadorResultadosImplAdapter implements PublicacionFormatterResultsIntPort {
    @Override
   public void retornarRespuestaErrorEntidadExiste(String mensaje) {
        EntidadYaExisteException objException = new EntidadYaExisteException(mensaje);
        throw objException;
    }

    //@Override
    public void retornarRespuestaErrorReglaDeNegocio(String mensaje) {
        ReglaNegocioExcepcion objException = new ReglaNegocioExcepcion(mensaje);
        throw objException;
    }
}
