package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;

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

    @NotBlank(message = "El correo no puede estar vacio")
    @NotEmpty(message = "{docente.correo.empty}")
    @Email(message="{docente.correo.email}")
    private String correo;

    private String vinculacion;

    @NotEmpty(message = "{docente.departamento.empty}")
    private String departamento;

    @NotEmpty(message = "{docente.direccion.empty}")
    private DireccionDTORequest direccionDTORequest;

    private List<PublicacionDTORequest> publicaciones;

}
