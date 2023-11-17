package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.controladores;

import co.edu.unicauca.asae.proyecto_cpd_fiet.aplication.input.ManagementPublicacionCUIntPort;
import co.edu.unicauca.asae.proyecto_cpd_fiet.dominio.models.Publicacion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORequest.PublicacionDTORequest;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOResponse.PublicacionDTOResponse;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.mappers.PublicacionIntMapperInfrastructureDomain;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.output.persistencia.repositorios.PublicacionesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PublicacionRestcontroller {

    private final ManagementPublicacionCUIntPort managementPublicacionCUIntPort;
    private final PublicacionIntMapperInfrastructureDomain publicacionMapper;
    //private final ModelMapper modelMapper;



    @PostMapping("/publicaciones")
    public ResponseEntity<PublicacionDTOResponse> create(@RequestBody PublicacionDTORequest publicacion) {

        //modelMapper.getConfiguration().setAmbiguityIgnored(true);
        Publicacion publicacionCreate = publicacionMapper.mapperRequestToPublicacion(publicacion);
        Publicacion publicacionAux = managementPublicacionCUIntPort.create(publicacionCreate);
        ResponseEntity<PublicacionDTOResponse> response = new ResponseEntity<PublicacionDTOResponse>(
                publicacionMapper.mapperPublicacionToResponse(publicacionAux),
                HttpStatus.CREATED);
        return response;

    }

    @GetMapping("/publicaciones")
    public ResponseEntity<List<PublicacionDTOResponse>> findAll() {

        List<Publicacion> publicaciones = this.managementPublicacionCUIntPort.findAll();
        List<PublicacionDTOResponse> listPublicaciones = this.publicacionMapper.mapperPublicacionesToResponse(publicaciones);

        ResponseEntity<List<PublicacionDTOResponse>> response = new ResponseEntity<List<PublicacionDTOResponse>>
                (listPublicaciones,
                HttpStatus.OK
                );
        return response;

    }
    @GetMapping("/publicacionesLazy")
    public ResponseEntity<List<PublicacionDTOResponse>> listarLazy(){
        List<Publicacion> publicaciones = this.managementPublicacionCUIntPort.findAll();


        ResponseEntity<List<PublicacionDTOResponse>> objRespuesta = new ResponseEntity<List<PublicacionDTOResponse>>(
                publicacionMapper.mapperPublicacionesToResponse(publicaciones),
                HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/publicaciones/patron-titulo")
    public ResponseEntity<List<PublicacionDTOResponse>> findAllPatron(@RequestParam String patronTitulo ) {
        List<PublicacionDTOResponse> publicaciones = this.managementPublicacionCUIntPort.consultarPublicacionPorPatron(patronTitulo);

        ResponseEntity<List<PublicacionDTOResponse>> response = new ResponseEntity<List<PublicacionDTOResponse>>
                (publicaciones,
        HttpStatus.OK);
        return response;
    }

    @PutMapping("/publicaciones")
    public ResponseEntity<PublicacionDTOResponse> asignar(@RequestParam String correo,@RequestParam String titulo){
        Publicacion publicacionConsultada = this.managementPublicacionCUIntPort.asignarPublicacionDocente(correo, titulo);
        ResponseEntity<PublicacionDTOResponse> publicacionRespuesta = new ResponseEntity<PublicacionDTOResponse>(
                publicacionMapper.mapperPublicacionToResponse(publicacionConsultada),
                HttpStatus.CREATED
        );
        return publicacionRespuesta;
    }

}
