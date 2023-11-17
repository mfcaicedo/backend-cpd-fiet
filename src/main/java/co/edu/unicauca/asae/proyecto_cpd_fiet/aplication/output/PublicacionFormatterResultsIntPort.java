package co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output;

public interface PublicacionFormatterResultsIntPort {
    public void retornarRespuestaErrorEntidadExiste(String mensaje);

    public void retornarRespuestaErrorReglaDeNegocio(String mensaje);
}
