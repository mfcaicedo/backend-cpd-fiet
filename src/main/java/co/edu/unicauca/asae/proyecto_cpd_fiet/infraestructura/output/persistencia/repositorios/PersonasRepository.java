package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PersonaEntity;

public interface PersonasRepository extends JpaRepository <PersonaEntity, Integer> {
    
}
