package co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.controladores;

import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTOPetecion.PublicacionDTOPeticion;
import co.edu.unicauca.asae.proyecto_cpd_fiet.infraestructura.input.controllerGestionarPublicaciones.DTORespuesta.PublicacionDTORespuesta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PublicacionRestcontroller {

    /* Controlador rest para crear publicaciones y listar la spublicaciones*/

    //@PostMapping("/publicaciones")

    /*
    public ResponseEntity<PublicacionDTORespuesta> create(@RequestBody PublicacionDTOPeticion objPublicacion) {

        ResponseEntity<?> objRespuesta = new ResponseEntity<PublicacionDTORespuesta>(, HttpStatus.CREATED);

        return objRespuesta;
    }
    */
}
