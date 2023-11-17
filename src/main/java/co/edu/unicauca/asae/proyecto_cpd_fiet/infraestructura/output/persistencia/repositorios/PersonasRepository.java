package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PersonaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonasRepository extends JpaRepository <PersonaEntity, Integer> {
    @Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE LOWER(d.correo) = LOWER(:correo)")
    boolean existsByCorreo(@Param("correo") String correo);
}
