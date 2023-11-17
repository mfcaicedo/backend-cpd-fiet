package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementPublicacionGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.PublicacionesRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ManagementPublicacionGatewayImplAdapter implements ManagementPublicacionGatewayIntPort {

    private final PublicacionesRepository publicacionesRepository;
    private final ModelMapper publicacionMapper;

    public ManagementPublicacionGatewayImplAdapter(
            PublicacionesRepository publicacionesRepository,
          ModelMapper publicacionMapper
    ) {
        this.publicacionesRepository = publicacionesRepository;
        this.publicacionMapper = publicacionMapper;
    }

    @Override
    public boolean validarPublicacionById(String id) {
        return false;
    }

    @Override
    public boolean validarPublicacionByTitulo(String titulo) {

        return this.publicacionesRepository.existsByTitulo(titulo);
    }

    @Override
    public Publicacion create(Publicacion publicacion) {


        PublicacionEntity publicacionEntity = publicacionMapper.map(publicacion,PublicacionEntity.class);
        return this.publicacionMapper.map(this.publicacionesRepository.save(publicacionEntity), Publicacion.class);

    }

    @Override
    public Publicacion actualizar(Publicacion publicacion) {
        PublicacionEntity publicacionEntity = publicacionMapper.map(publicacion,PublicacionEntity.class);
        return this.publicacionMapper.map(this.publicacionesRepository.save(publicacionEntity), Publicacion.class);
    }

    @Override
    public List<Publicacion> findAll() {

        Iterable<PublicacionEntity> publicaciones = this.publicacionesRepository.findAll();
        List<Publicacion> listPublicaciones = this.publicacionMapper.map(publicaciones, new TypeToken<List<Publicacion>>() {
        }.getType());
        return listPublicaciones;

    }

    @Override
    public List<PublicacionDTOResponse> consultarPublicacionPorPatron(String titulo) {
        System.out.println("patron " + titulo);

        Iterable<PublicacionEntity> publicaciones = this.publicacionesRepository.findByTituloIgnoreCaseContainingOrderByIdPublicacion(titulo);;
        List<PublicacionDTOResponse> listPublicaciones = this.publicacionMapper.map(publicaciones, new TypeToken<List<PublicacionDTOResponse>>() {
        }.getType());
        return listPublicaciones;
    }

    @Override
    public Publicacion consultarPublicacionPorTitulo(String titulo) {
        return this.publicacionMapper.map(this.publicacionesRepository.findByTitulo(titulo), Publicacion.class);
    }

    @Override
    public Publicacion asignarPublicacionDocente(String correo, String titulo) {
        return null;
    }
}
