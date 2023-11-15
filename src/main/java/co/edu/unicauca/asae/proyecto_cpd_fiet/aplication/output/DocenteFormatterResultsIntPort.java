package co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output;

import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;

public interface DocenteFormatterResultsIntPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
