package co.edu.unicauca.asae.proyecto_cpd_fiet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_cpd_fiet.models.DocentesEntity;
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


		private void guardarDocentes() {
		DocentesEntity objDocente1 = new Docentes("1","Calle 26 EN #4-50","Popayan", "Colombia");
		Empleado objEmpleado2 = new Empleado("Juan", "Lopez", "Jumbo");
		List<Empleado> listaEmpleados = new LinkedList();
		listaEmpleados.add(objEmpleado1);
		listaEmpleados.add(objEmpleado2);
		this.servicioBDEmpleados.saveAll(listaEmpleados);
	}

}
