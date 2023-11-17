package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class TipoDTOResponse {

    private Integer idTipo;
    private String nombre;
    @JsonIgnore
    private List<PublicacionDTOResponse> publicaciones;

}
