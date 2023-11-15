package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.controllers;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfrastructureDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DocenteRestController {

    private final ManagementDocenteCUIntPort managementDocenteCUIntPort;
    private final DocenteMapperInfrastructureDomain mapeadorDocente;
    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTOResponse> create(@RequestBody DocenteDTORequest docente) {

        Docente docenteCreate = mapeadorDocente.mapperRequestToDocente(docente);
        Docente docenteAux = managementDocenteCUIntPort.create(docenteCreate);
        ResponseEntity<DocenteDTOResponse> response = new ResponseEntity<DocenteDTOResponse>(
                mapeadorDocente.mapperDocenteToResponse(docenteAux),
                HttpStatus.CREATED);
        return response;

    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTOResponse>> findAll() {
        /*ResponseEntity<List<DocenteDTOResponse>> objRespuesta = new ResponseEntity<List<DocenteDTOResponse>>(
                mapeadorDocente.mapperDocentesToResponse(this.managementDocenteCUIntPort.findAll()),
                HttpStatus.OK);
        return objRespuesta;*/
        return null;
    }

}
