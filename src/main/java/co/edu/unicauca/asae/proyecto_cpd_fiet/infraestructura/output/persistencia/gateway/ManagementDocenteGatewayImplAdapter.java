package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.gateway;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.output.ManagementDocenteGatewayIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.DocenteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ManagementDocenteGatewayImplAdapter implements ManagementDocenteGatewayIntPort {

    @Qualifier("docenteServiceModelMapper")
    private final ModelMapper docenteModelMapper;
    private final DocenteRepository docenteRepository;

    public ManagementDocenteGatewayImplAdapter(DocenteRepository docenteRepository,
                                               ModelMapper docenteModelMapper) {
        this.docenteRepository = docenteRepository;
        this.docenteModelMapper = docenteModelMapper;
    }

    @Override
    public boolean validProducctoByCodigo(String codigo) {
        return false;
    }

    @Override
    public Docente create(Docente docente) {
        DocenteEntity objDocenteEntity = this.docenteModelMapper.map(docente , DocenteEntity.class);
        DocenteEntity objDocenteRegistrado = this.docenteRepository.save(objDocenteEntity);

        Docente objDocenteResponse = this.docenteModelMapper.map(objDocenteRegistrado, Docente.class);
        return objDocenteResponse;
    }
}
