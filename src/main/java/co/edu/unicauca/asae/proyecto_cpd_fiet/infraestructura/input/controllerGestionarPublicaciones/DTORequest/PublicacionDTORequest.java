package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PublicacionDTORequest {


    private Integer idPublicacion;

    @NotEmpty(message="{publicacion.titulo.empty}")
    private String titulo;

    @NotEmpty(message = "{publicacion.area.empty}")
    private String area;

    //@NotEmpty(message = "{publicacion.tipo.empty}")
    private TipoDTORequest tipo;

    private List<DocenteDTORequest> docentes;

}
