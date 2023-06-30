package ar.edu.utn.frc.tup.lciii.practicalciitruco.Controllers;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.JugadorService;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador.JugadorRespuestaDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador.NuevoJugadorPeticionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/jugadores")
public class JugadoresController {
    @Autowired
    private JugadorService jugadorService;
    @PostMapping("")
    public ResponseEntity<JugadorRespuestaDTO>nuevoJugador(@RequestBody NuevoJugadorPeticionDTO nuevoJugadorPeticionDTO){
        JugadorRespuestaDTO nuevoJugador=jugadorService.guardarJugador(nuevoJugadorPeticionDTO);
        if(Objects.isNull(nuevoJugador)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El jugador no se pudo crear");
        }
        return ResponseEntity.ok(nuevoJugador);
    }
    @GetMapping("/{idJugador}")
    public ResponseEntity<JugadorRespuestaDTO>getJugadorByID(@PathVariable Long idJugador){
        JugadorRespuestaDTO jugador=jugadorService.getJugadorRespuestaDTOById(idJugador);
        return ResponseEntity.ok(jugador);
    }



}
