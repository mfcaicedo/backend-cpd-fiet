package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {
    @Query("SELECT COUNT(d) > 0 FROM DocenteEntity d WHERE LOWER(d.correo) = LOWER(:correo)")
    boolean existsByCorreo(@Param("correo") String correo);

    DocenteEntity findByCorreo(String correo);
}
