package co.edu.unicauca.asae.proyecto_cpd_fiet.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Docente;

public interface DocentesRepository extends JpaRepository<Docente, Integer> {
}
