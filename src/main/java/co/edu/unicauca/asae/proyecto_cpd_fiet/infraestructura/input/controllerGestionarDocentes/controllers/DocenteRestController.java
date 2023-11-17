package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.controllers;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementDocenteCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Direccion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Docente;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTOReponse.DocenteDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DireccionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.DTORequest.DocenteDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfrastructureDomain;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DireccionEntity;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.entidades.DocenteEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DocenteRestController {

    private final ManagementDocenteCUIntPort managementDocenteCUIntPort;
   // private final DocenteMapperInfrastructureDomain mapeadorDocente;
    private final ModelMapper modelMapper;
    // private final DocenteMapperInfrastructureDomain mapperRequestDocente;

    @Autowired
    public DocenteRestController(ManagementDocenteCUIntPort managementDocenteCUIntPort,
                                @Qualifier("docenteModelMapperController") ModelMapper modelMapper) {
        this.managementDocenteCUIntPort = managementDocenteCUIntPort;
       // this.mapeadorDocente = mapeadorDocente;
        this.modelMapper = modelMapper;
    }
    @PostMapping("/docentes")
    public ResponseEntity<DocenteDTOResponse> create(@RequestBody DocenteDTORequest docente) {


       /* DireccionEntity direccionEntity = modelMapper.map(docente.getDireccionDTORequest(),DireccionEntity.class);
        DocenteEntity docenteEntity = modelMapper.map(docente, DocenteEntity.class);

        direccionEntity.setDocenteEntity(docenteEntity);
        docenteEntity.setDireccionEntity(direccionEntity);*/


        //Docente docenteCreate1 = modelMapper.map(docenteEntity, Docente.class);

        Docente docenteCreate = modelMapper.map(docente, Docente.class);


//        Docente docenteAux = managementDocenteCUIntPort.create(docenteCreate1);
        Docente docenteAux = managementDocenteCUIntPort.create(modelMapper.map(docenteCreate, Docente.class));

        ResponseEntity<DocenteDTOResponse> response = new ResponseEntity<DocenteDTOResponse>(
                modelMapper.map(docenteAux, DocenteDTOResponse.class),
                HttpStatus.CREATED);
        return response;

    }

    @GetMapping("/docentes")
    public ResponseEntity<List<DocenteDTOResponse>> findAll() {
        System.out.println("si lllega al get ");
        DocenteDTOResponse docente = new DocenteDTOResponse();
        docente.setNombres("Juan");
        docente.setApellidos("Perez");
        List<DocenteDTOResponse> docentes = List.of(docente);

        return new ResponseEntity<List<DocenteDTOResponse>>(
            docentes,
            HttpStatus.OK
        );
        /*ResponseEntity<List<DocenteDTOResponse>> objRespuesta = new ResponseEntity<List<DocenteDTOResponse>>(
                mapeadorDocente.mapperDocentesToResponse(this.managementDocenteCUIntPort.findAll()),
                HttpStatus.OK);
        return objRespuesta;*/
    }

}
