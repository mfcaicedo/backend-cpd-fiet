package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.controladores;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementPublicacionCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.mappers.PublicacionMapperInfrastructureDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PublicacionRestcontroller {

    private final ManagementPublicacionCUIntPort managementPublicacionCUIntPort;
    private final PublicacionMapperInfrastructureDomain mapeadorPublicacion;
    @PostMapping("/publicaciones")
    public ResponseEntity<PublicacionDTOResponse> create(@RequestBody PublicacionDTORequest publicacion) {

        Publicacion publicacionCreate = mapeadorPublicacion.mapperRequestToPublicacion(publicacion);
        Publicacion publicacionAux = managementPublicacionCUIntPort.create(publicacionCreate);
        ResponseEntity<PublicacionDTOResponse> response = new ResponseEntity<PublicacionDTOResponse>(
                mapeadorPublicacion.mapperPublicacionToResponse(publicacionAux),
                HttpStatus.CREATED);
        return response;

    }

    @GetMapping("/publicaciones")
    public ResponseEntity<List<PublicacionDTOResponse>> findAll() {

        ResponseEntity<List<PublicacionDTOResponse>> response = new ResponseEntity<List<PublicacionDTOResponse>>(
                mapeadorPublicacion.mapperPublicacionesToResponse(this.managementPublicacionCUIntPort.findAll()),
                HttpStatus.OK);
        return response;

    }

}
