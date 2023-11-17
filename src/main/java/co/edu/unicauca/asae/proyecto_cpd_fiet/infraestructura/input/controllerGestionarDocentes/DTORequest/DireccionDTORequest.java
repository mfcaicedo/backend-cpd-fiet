package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DireccionDTORequest {

    private Integer idPersona;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
    private DocenteDTORequest docenteDTORequest;

}
