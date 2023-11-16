package co.edu.unicauca.asae.proyecto_cpd_fiet;

import java.util.LinkedList;
import java.util.List;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.TipoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.DocenteRepository;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.PublicacionesRepository;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.TiposRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
//@ComponentScan(basePackages = "co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers")
public class ProyectoCpdFietApplication {

	/*@Autowired
	private DocenteRepository servicioBDDocentes;
	@Autowired
	private PublicacionesRepository servicioBDPublicaciones;
	@Autowired
	private TiposRepository servicioBDTipos;
*/
	public static void main(String[] args) {

		SpringApplication.run(ProyectoCpdFietApplication.class, args);
	}

/*	@Override
	public void run(String... args) throws Exception {
		guardarDocentes();
		registrarPublicacion();
		consultarPublicaciones();
	}*/

	/*private void guardarDocentes() {

		DocenteEntity objDocente1Entity = new DocenteEntity( "Cedula", "1002971825", "Piter", "Alveiro", "asdasd@unicauca.edu.co",
				"2017", "Telematica");
		DocenteEntity objDocente2Entity = new DocenteEntity( "Cedula", "1002972323", "Carlos", "Marin", "fabianxd@unicauca.edu.co",
				"2015", "Sistemas");

		DocenteEntity objDocente3Entity = new DocenteEntity( "Cedula", "1002972323", "Carlos", "Marin", "fabianxd@unicauca.edu.co",
				"2015", "Sistemas");

		List<DocenteEntity> listaDocenteEntities = new LinkedList();
		listaDocenteEntities.add(objDocente1Entity);
		listaDocenteEntities.add(objDocente2Entity);
		listaDocenteEntities.add(objDocente3Entity);

		DireccionEntity objDireccion1Entity =  new DireccionEntity();
		objDireccion1Entity.setCiudad("Popayan");
		objDireccion1Entity.setDireccionResidencia("Calle 26 EN #4-50");
		objDireccion1Entity.setPais("Colombia");

		objDireccion1Entity.setDocenteEntity(objDocente1Entity);
		objDocente1Entity.setDireccionEntity(objDireccion1Entity);

		DireccionEntity objDireccion2Entity =  new DireccionEntity();
		objDireccion2Entity.setCiudad("Popayan");
		objDireccion2Entity.setDireccionResidencia("Calle 890i387 EN #4-50");
		objDireccion2Entity.setPais("Colombia");

		objDireccion2Entity.setDocenteEntity(objDocente2Entity);
		objDocente2Entity.setDireccionEntity(objDireccion2Entity);

		DireccionEntity objDireccion3Entity =  new DireccionEntity();
		objDireccion3Entity.setCiudad("Popayan");
		objDireccion3Entity.setDireccionResidencia("Calle 0000 EN #4-50");
		objDireccion3Entity.setPais("Colombia");

		objDireccion3Entity.setDocenteEntity(objDocente3Entity);
		objDocente3Entity.setDireccionEntity(objDireccion3Entity);

		this.servicioBDDocentes.saveAll(listaDocenteEntities);

	}*/

	/*private void registrarPublicacion() {
		TipoEntity tipoEntity = new TipoEntity();
		tipoEntity.setNombre("Arte");
		tipoEntity = servicioBDTipos.save(tipoEntity);
		PublicacionEntity objPublicacion1Entity = new PublicacionEntity(1, "El arte de la guerra", "Historia", tipoEntity, retornoDocente());
		PublicacionEntity objPublicacion2Entity = new PublicacionEntity(2, "Game of thrones", "Fantasia", tipoEntity, retornoDocente());
		List<PublicacionEntity> listaPublicaciones = new LinkedList();
		listaPublicaciones.add(objPublicacion1Entity);
		listaPublicaciones.add(objPublicacion2Entity);
		this.servicioBDPublicaciones.saveAll(listaPublicaciones);
	}*/

	/*private List<DocenteEntity> retornoDocente(){
		return this.servicioBDDocentes.findAll();
	}*/

	/*private void consultarPublicaciones() {
		Iterable<PublicacionEntity> listaPublicaciones = this.servicioBDPublicaciones.findAll();
		for (PublicacionEntity publicacionEntity : listaPublicaciones) {
			System.out.println("----");
			System.out.println("Id publicación: " + publicacionEntity.getIdPublicacion());
			System.out.println("Area: " + publicacionEntity.getArea());
			System.out.println("Titulo: " + publicacionEntity.getTitulo());
			System.out.println("TipoEntity: " + publicacionEntity.getTipoEntity().getNombre());
			System.out.print("Docentes: ");
			publicacionEntity.getDocenteEntityPublicacion().forEach(docente -> System.out.println(docente.getNombres()));
			System.out.println("------ \n\n");
		}
	}*/

}
