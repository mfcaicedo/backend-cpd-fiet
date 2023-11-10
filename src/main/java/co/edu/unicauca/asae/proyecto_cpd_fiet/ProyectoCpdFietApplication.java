package co.edu.unicauca.asae.proyecto_cpd_fiet;

import java.util.LinkedList;
import java.util.List;

import co.edu.unicauca.asae.proyecto_cpd_fiet.Repositories.DireccionRepository;
import co.edu.unicauca.asae.proyecto_cpd_fiet.Repositories.DocentesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Direccion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Tipo;

import co.edu.unicauca.asae.proyecto_cpd_fiet.repositories.PublicacionesRepository;
import co.edu.unicauca.asae.proyecto_cpd_fiet.repositories.TiposRepository;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@Transactional
public class ProyectoCpdFietApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProyectoCpdFietApplication.class);

	@Autowired
	private DocentesRepository servicioBDDocentes;

	@Autowired
	private PublicacionesRepository servicioBDPublicaciones;

	
	@Autowired
	private TiposRepository servicioBDTipos;

	@Autowired
	private DireccionRepository direccionRepository;


	public static void main(String[] args) {
		SpringApplication.run(ProyectoCpdFietApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Iniciando el método run...");
		try{
			this.guardarDocentes();
			this.registrarPublicacion();
			this.consultarPublicaciones();
		}catch(Exception e ){
			e.printStackTrace();
		}
		logger.info("Fin del método run.");


	}

	@Transactional
	private void guardarDocentes() {
		Docente docente2 = new Docente(2, "Cedula", "1002972323", "Carlos", "Marin", "fabianxd@unicauca.edu.co",
				"2015", "Sistemas");
		Docente docente = new Docente(1, "Cedula", "1002971825", "Piter", "Alveiro", "asdasd@unicauca.edu.co",
				"2017", "Telematica");


		List<Direccion> listaDirecciones = new LinkedList();
		Direccion direccion = new Direccion();
		Direccion direccion2 = new Direccion();

		direccion.setPais("Colombia");
		direccion.setCiudad("Popayan");
		direccion.setDireccionResidencia("calle 30 an #");
		// listaDirecciones.add(direccion);

		direccion.setDocente(docente);
		docente.setDireccion(direccion);

		direccion2.setPais("Colombia");
		direccion2.setCiudad("Popayan");
		direccion2.setDireccionResidencia("calle 80000 an #");
		//listaDirecciones.add(direccion2);

		direccion2.setDocente(docente2);
		docente2.setDireccion(direccion2);

		List<Docente> listaDocentes = new LinkedList();
		listaDocentes.add(docente);
		listaDocentes.add(docente2);




		//this.direccionRepository.saveAll(listaDirecciones);
		this.servicioBDDocentes.saveAll(listaDocentes);


	}

	
	private void registrarPublicacion() {
		Tipo tipo = new Tipo();
		tipo.setNombre("Arte");
		tipo = servicioBDTipos.save(tipo);
		Publicacion objPublicacion1 = new Publicacion(1, "El arte de la guerra", "Historia", tipo, retornoDocente());
		Publicacion objPublicacion2 = new Publicacion(2, "Game of thrones", "Fantasia", tipo, retornoDocente());
		List<Publicacion> listaPublicaciones = new LinkedList();
		listaPublicaciones.add(objPublicacion1);
		listaPublicaciones.add(objPublicacion2);
		this.servicioBDPublicaciones.saveAll(listaPublicaciones);
	}

	private List<Docente> retornoDocente(){
		return this.servicioBDDocentes.findAll();
	}

	private void consultarPublicaciones() {
		Iterable<Publicacion> listaPublicaciones = this.servicioBDPublicaciones.findAll();
		for (Publicacion publicacion : listaPublicaciones) {
			System.out.println("-----");
			System.out.println("Id publicación: " + publicacion.getIdPublicacion());
			System.out.println("Area: " + publicacion.getArea());
			System.out.println("Titulo: " + publicacion.getTitulo());
			System.out.println("Tipo: " + publicacion.getTipo().getNombre());
			System.out.print("Docentes: ");
			publicacion.getDocentePublicacion().forEach(docente -> System.out.println(docente.getNombres()));
			System.out.println("----- \n\n");
		}
	}

}
