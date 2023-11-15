package co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Direccion {

    private Integer idPersona;
    private String direccionResidencia;
    private String ciudad;
    private String pais;
    private DocenteEntity docenteEntity;

}
