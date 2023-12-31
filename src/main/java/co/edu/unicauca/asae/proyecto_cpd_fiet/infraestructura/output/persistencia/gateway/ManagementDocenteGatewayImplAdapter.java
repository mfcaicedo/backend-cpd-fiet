package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.DocenteRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagementDocenteGatewayImplAdapter implements ManagementDocenteGatewayIntPort {

    private final ModelMapper docenteModelMapper;
    private final DocenteRepository docenteRepository;

    //private final ModelMapper modelMapper;
    public ManagementDocenteGatewayImplAdapter(DocenteRepository docenteRepository,
                                               ModelMapper docenteModelMapper
                                              ) {
        this.docenteRepository = docenteRepository;
        this.docenteModelMapper = docenteModelMapper;

    }

    @Override
    public boolean validarDocentePorCorreo(String correo) {
        return this.docenteRepository.existsByCorreo(correo);
    }

    @Override
    public Docente create(Docente docente) {

        DireccionEntity direccionEntity = docenteModelMapper.map(docente.getDireccion(),DireccionEntity.class);
        DocenteEntity docenteEntity = docenteModelMapper.map(docente, DocenteEntity.class);

        direccionEntity.setDocenteEntity(docenteEntity);
        docenteEntity.setDireccion(direccionEntity);

        DocenteEntity objDocenteRegistrado = this.docenteRepository.save(docenteEntity);

        Docente objDocenteResponse = this.docenteModelMapper.map(objDocenteRegistrado, Docente.class);
        return objDocenteResponse;
    }

    @Override
    public Docente consultarDocentePorCorreo(String correo) {
        return this.docenteModelMapper.map(this.docenteRepository.findByCorreo(correo),Docente.class);
    }

    @Override
    public List<Docente> findAll() {

        Iterable<DocenteEntity> docentes = this.docenteRepository.findAll();
        List<Docente> listDocentes = this.docenteModelMapper.map(docentes, new TypeToken<List<Docente>>() {
        }.getType());
        return listDocentes;

    }
}
