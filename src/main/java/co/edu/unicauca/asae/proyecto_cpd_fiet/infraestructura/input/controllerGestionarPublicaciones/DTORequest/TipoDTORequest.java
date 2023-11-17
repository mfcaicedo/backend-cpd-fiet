package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class TipoDTORequest {

    private Integer idTipo;
    private String nombre;
    //private List<PublicacionDTORequest> publicaciones;

}
