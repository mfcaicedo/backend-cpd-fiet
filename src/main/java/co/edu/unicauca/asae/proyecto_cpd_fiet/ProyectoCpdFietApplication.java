package co.edu.unicauca.asae.proyecto_cpd_fiet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.repositories.DocentesRepository;

@SpringBootApplication
public class ProyectoCpdFietApplication implements CommandLineRunner {

	@Autowired
	private DocentesRepository servicioBDDocentes;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCpdFietApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}




}
