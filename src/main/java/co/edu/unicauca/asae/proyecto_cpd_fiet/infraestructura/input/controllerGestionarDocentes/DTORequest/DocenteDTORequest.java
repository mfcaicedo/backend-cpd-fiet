package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class DocenteDTORequest {

    @NotNull(message="{docente.id.}")
    private Integer idPersona;
    private String tipoIdentificacion;
    @Size(min=5, max = 11, message="{}")
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    @Email(message="{}")
    private String correo;
    private String vinculacion;
    private String departamento;
    private DireccionDTORequest direccionDTORequest;
    private List<PublicacionEntity> publicaciones;

}
