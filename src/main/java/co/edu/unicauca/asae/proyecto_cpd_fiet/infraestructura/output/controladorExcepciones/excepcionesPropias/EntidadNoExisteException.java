package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.excepcionesPropias;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.controladorExcepciones.estructuraExcepciones.CodigoError;
import lombok.Getter;

@Getter
public class EntidadNoExisteException extends  RuntimeException{

    private final String llaveMensaje;
    private final String codigo;

    public EntidadNoExisteException(CodigoError code) {
        super(code.getCodigo());
        this.llaveMensaje = code.getLlaveMensaje();
        this.codigo = code.getCodigo();
    }

    public EntidadNoExisteException(final String message) {
        super(message);
        this.llaveMensaje = CodigoError.ENTIDAD_NO_ENCONTRADA.getLlaveMensaje();
        this.codigo = CodigoError.ENTIDAD_NO_ENCONTRADA.getCodigo();
    }
}
