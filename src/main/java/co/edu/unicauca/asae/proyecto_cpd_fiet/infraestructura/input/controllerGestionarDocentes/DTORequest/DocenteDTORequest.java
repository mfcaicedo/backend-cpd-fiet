package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTORequest {

    private Integer idPersona;
    private String tipoIdentificacion;

    @Size(min=5, max = 11, message="{docente.longitud.numeroidenticacion}")
    private String numeroIdentificacion;

    @NotNull(message = "{docente.nombres.notnull}")
    private String nombres;

    @NotNull(message = "{docente.apellido.notnull}")
    private String apellidos;

    @NotBlank(message = "{docente.correo.notblank}")
    @NotEmpty(message = "{docente.correo.empty}")
    @Email(message="{docente.correo.email}")
    private String correo;

    private String vinculacion;

    @NotEmpty(message = "{docente.departamento.empty}")
    private String departamento;

    @NotNull(message = "{docente.direccion.notnull}")
    private DireccionDTORequest direccion;

    private List<PublicacionDTORequest> publicaciones;

}
