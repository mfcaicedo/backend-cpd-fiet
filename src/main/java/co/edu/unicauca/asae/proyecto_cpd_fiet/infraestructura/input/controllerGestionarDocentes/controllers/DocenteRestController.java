package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.controllers;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Direccion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DireccionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfrastructureDomain;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
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

@RestController
@RequestMapping("/api")
@Validated
@RequiredArgsConstructor
public class DocenteRestController {
    private final ManagementDocenteCUIntPort managementDocenteCUIntPort;
   // private final DocenteMapperInfrastructureDomain mapeadorDocente;
    private final ModelMapper modelMapper;
    // private final DocenteMapperInfrastructureDomain mapperRequestDocente;


    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTOResponse> create(@Valid @RequestBody DocenteDTORequest docente) {

        Docente docenteCreate = modelMapper.map(docente, Docente.class);
        Docente docenteAux = managementDocenteCUIntPort.create(modelMapper.map(docenteCreate, Docente.class));
        ResponseEntity<DocenteDTOResponse> response = new ResponseEntity<DocenteDTOResponse>(
                modelMapper.map(docenteAux, DocenteDTOResponse.class),
                HttpStatus.CREATED);
        return response;

    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTOResponse>> findAll() {
        System.out.println("llega al get Docentes ");

        Iterable<Docente> docentes = this.managementDocenteCUIntPort.findAll();
        List<DocenteDTOResponse> listDocentes = this.modelMapper.map(docentes,
                new TypeToken<List<DocenteDTOResponse>>() {
                }.getType());

        ResponseEntity<List<DocenteDTOResponse>> response = new ResponseEntity<List<DocenteDTOResponse>>
                (listDocentes,
                        HttpStatus.OK
                );
        return response;

    }

}
