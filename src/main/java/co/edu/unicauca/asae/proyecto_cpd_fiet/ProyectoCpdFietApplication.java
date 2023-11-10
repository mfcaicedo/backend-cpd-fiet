package co.edu.unicauca.asae.proyecto_cpd_fiet;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Direccion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.models.Tipo;
import co.edu.unicauca.asae.proyecto_cpd_fiet.repositories.DocentesRepository;
import co.edu.unicauca.asae.proyecto_cpd_fiet.repositories.PublicacionesRepository;
import co.edu.unicauca.asae.proyecto_cpd_fiet.repositories.TiposRepository;

@SpringBootApplication
public class ProyectoCpdFietApplication implements CommandLineRunner {

	@Autowired
	private DocentesRepository servicioBDDocentes;

	@Autowired
	private PublicacionesRepository servicioBDPublicaciones;

	
	@Autowired
	private TiposRepository servicioBDTipos;



	public static void main(String[] args) {
		SpringApplication.run(ProyectoCpdFietApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		guardarDocentes();
		registrarPublicacion();
		consultarPublicaciones();
	}

	private void guardarDocentes() {
		Docente objDocente1 = new Docente(1, "Cedula", "1002971825", "Piter", "Alveiro", "asdasd@unicauca.edu.co",
				"2017", "Telematica");
		Docente objDocente2 = new Docente(2, "Cedula", "1002972323", "Carlos", "Marin", "fabianxd@unicauca.edu.co",
				"2015", "Sistemas");
		List<Docente> listaDocentes = new LinkedList();
			Direccion objDireccion1 =  new Direccion();
		objDireccion1.setCiudad("Popayan");
		objDireccion1.setDireccionResidencia("Calle 26 EN #4-50");
		objDireccion1.setPais("Colombia");
		objDireccion1.setDocente(objDocente1);
		objDocente1.setDireccion(objDireccion1);
		listaDocentes.add(objDocente1);
		listaDocentes.add(objDocente2);
		this.servicioBDDocentes.saveAll(listaDocentes);
		//this.servicioBDDocentes.save(objDocente1);
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
			System.out.println("Id publicación: " + publicacion.getIdPublicacion());
			System.out.println("Area: " + publicacion.getArea());
			System.out.println("Titulo: " + publicacion.getTitulo());
			System.out.println("Tipo: " + publicacion.getTipo().getNombre());
			System.out.println("Docentes: ");
			publicacion.getDocentePublicacion().forEach(docente -> System.out.println(docente.getNombres()));
		}
	}

}
