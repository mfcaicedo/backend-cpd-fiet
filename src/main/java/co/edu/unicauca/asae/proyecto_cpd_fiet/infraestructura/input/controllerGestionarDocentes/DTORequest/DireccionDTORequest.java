package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.Null;

@Getter
@Setter
@AllArgsConstructor
public class DireccionDTORequest {
    @Nullable
    private Integer idPersona;
    @Nullable
    private String direccionResidencia;
    @Nullable
    private String ciudad;
    @Nullable
    private String pais;
    @Nullable
    private DocenteDTORequest docenteDTORequest;

}
