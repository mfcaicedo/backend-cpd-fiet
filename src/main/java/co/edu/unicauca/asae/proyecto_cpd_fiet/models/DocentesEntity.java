package co.edu.unicauca.asae.proyecto_cpd_fiet.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "docentes")
@Getter
@Setter
/*@AllArgsConstructor
@NoArgsConstructor*/
public class DocentesEntity extends PersonasEntity{

    public DocentesEntity(Integer idPersona, String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, DireccionesEntity direccion, String correo, String vinculacion, String departamento) {
        super(idPersona, tipoIdentificacion, numeroIdentificacion, nombres, apellidos, direccion);
        this.correo = correo;
        this.vinculacion = vinculacion;
        this.departamento = departamento;
    }

    @Column
    private String correo;

    @Column
    private String vinculacion;

    @Column
    private String departamento;

}
