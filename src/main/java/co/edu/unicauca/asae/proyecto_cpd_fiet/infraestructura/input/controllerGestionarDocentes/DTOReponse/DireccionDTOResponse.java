package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DireccionDTOResponse {

    private Integer idPersona;
    private String direccionResidencia;
    private String ciudad;
    private String pais;

}
