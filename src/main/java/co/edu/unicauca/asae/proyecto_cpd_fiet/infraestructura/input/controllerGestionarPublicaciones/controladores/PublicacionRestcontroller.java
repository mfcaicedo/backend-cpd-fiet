package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.controladores;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementPublicacionCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.mappers.PublicacionMapperInfrastructureDomain;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.PublicacionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.PublicacionesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api")
public class PublicacionRestcontroller {

    private final ManagementPublicacionCUIntPort managementPublicacionCUIntPort;
    private final PublicacionMapperInfrastructureDomain mapeadorPublicacion;
    private final ModelMapper modelMapper;
    private PublicacionesRepository publicacionesRepository;

    public PublicacionRestcontroller(ManagementPublicacionCUIntPort managementPublicacionCUIntPort,
                                     PublicacionMapperInfrastructureDomain mapeadorPublicacion,
                                    @Qualifier("publicacionModelMapper") ModelMapper modelMapper,
                                     PublicacionesRepository publicacionesRepository
    ) {
        this.managementPublicacionCUIntPort = managementPublicacionCUIntPort;
        this.mapeadorPublicacion = mapeadorPublicacion;
        this.modelMapper = modelMapper;
        this.publicacionesRepository = publicacionesRepository;
    }

    @PostMapping("/publicaciones")
    public ResponseEntity<PublicacionDTOResponse> create(@Valid  @RequestBody PublicacionDTORequest publicacion) {

        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Publicacion publicacionCreate = modelMapper.map(publicacion, Publicacion.class);
        Publicacion publicacionAux = managementPublicacionCUIntPort.create(publicacionCreate);
        ResponseEntity<PublicacionDTOResponse> response = new ResponseEntity<PublicacionDTOResponse>(
                mapeadorPublicacion.mapperPublicacionToResponse(publicacionAux),
                HttpStatus.CREATED);
        return response;

    }

    @GetMapping("/publicaciones")
    public ResponseEntity<List<PublicacionDTOResponse>> findAll() {

        Iterable<Publicacion> publicaciones = this.managementPublicacionCUIntPort.findAll();

        List<PublicacionDTOResponse> listPublicaciones = this.modelMapper.map(publicaciones,
                new TypeToken<List<PublicacionDTOResponse>>() {
        }.getType());

        ResponseEntity<List<PublicacionDTOResponse>> response = new ResponseEntity<List<PublicacionDTOResponse>>
                (listPublicaciones,
                HttpStatus.OK
                );
        return response;

    }

    @GetMapping("/publicaciones/patron-titulo")
    public ResponseEntity<List<PublicacionDTOResponse>> findAllPatron(@RequestParam String patronTitulo ) {
        List<PublicacionDTOResponse> publicaciones = this.managementPublicacionCUIntPort.consultarPublicacionPorPatron(patronTitulo);

        ResponseEntity<List<PublicacionDTOResponse>> response = new ResponseEntity<List<PublicacionDTOResponse>>
                (publicaciones,
        HttpStatus.OK);
        return response;
    }

}
