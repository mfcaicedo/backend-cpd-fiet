package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.formateador;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.excepcionesPropias.EntidadYaExisteException;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.excepcionesPropias.ReglaNegocioExcepcion;
import org.springframework.stereotype.Service;

@Service
public class PublicacionFormateadorResultadosImplAdapter {

    //TODO implemeta el formateador de resultado Int port

    //@Override
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
