package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.TipoEntity;

import java.util.List;

public class PublicacionDTOResponse {

    private Integer idPublicacion;
    private String titulo;
    private String area;
    private TipoEntity tipoEntity;
    private List<DocenteEntity> docenteEntityPublicacion;

}
