package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.DocenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ManagementDocenteGatewayImplAdapter implements ManagementDocenteGatewayIntPort {

    private final ModelMapper docenteModelMapper;
    private final DocenteRepository docenteRepository;

    private final ModelMapper modelMapper;
    public ManagementDocenteGatewayImplAdapter(DocenteRepository docenteRepository,
                                              @Qualifier("docenteModelMapper") ModelMapper docenteModelMapper,
                                               @Qualifier("docenteModelMapperController") ModelMapper modelMapper) {
        this.docenteRepository = docenteRepository;
        this.docenteModelMapper = docenteModelMapper;
        this.modelMapper=modelMapper;
    }

    @Override
    public boolean validarDocentePorCorreo(String correo) {
        return this.docenteRepository.existsByCorreo(correo);
    }

    @Override
    public Docente create(Docente docente) {

        DireccionEntity direccionEntity = modelMapper.map(docente.getDireccion(),DireccionEntity.class);
        DocenteEntity docenteEntity = modelMapper.map(docente, DocenteEntity.class);

        direccionEntity.setDocenteEntity(docenteEntity);
        docenteEntity.setDireccionEntity(direccionEntity);

        DocenteEntity objDocenteRegistrado = this.docenteRepository.save(docenteEntity);

        Docente objDocenteResponse = this.docenteModelMapper.map(objDocenteRegistrado, Docente.class);
        return objDocenteResponse;
    }

    @Override
    public Docente consultarDocentePorCorreo(String correo) {
        return null;
    }
}
