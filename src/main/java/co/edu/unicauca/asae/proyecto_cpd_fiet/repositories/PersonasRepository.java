package co.edu.unicauca.asae.proyecto_cpd_fiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Persona;

public interface PersonasRepository extends JpaRepository <Persona, Integer> {
    
}