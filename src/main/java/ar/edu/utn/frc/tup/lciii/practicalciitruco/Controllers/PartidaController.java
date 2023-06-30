package ar.edu.utn.frc.tup.lciii.practicalciitruco.Controllers;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.PartidaService;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano.ManoPeticionDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano.ManoRespuestaDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida.NuevaPartidaPeticionDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida.PartidaRespuestaDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestController
@RequestMapping("/partidas")
public class PartidaController {
    @Autowired
    private PartidaService partidaService;

    @PostMapping("")
    public ResponseEntity<PartidaRespuestaDTO> crearPartida(@RequestBody  NuevaPartidaPeticionDTO nuevaPartidaPeticionDTO){
        PartidaRespuestaDTO nuevaPartida=partidaService.nuevaPartida(nuevaPartidaPeticionDTO);
        if(Objects.isNull(nuevaPartida)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"la partida no se pudo crear");
        }
        return ResponseEntity.ok(nuevaPartida);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaRespuestaDTO>getPartidaById(@PathVariable Long partidaId){
        PartidaRespuestaDTO partida=partidaService.getPartidaRespuestaDTOById(partidaId);
        return ResponseEntity.ok(partida);
    }

    @PostMapping("/{idPartida}/jugarmano/")
    public ResponseEntity<ManoRespuestaDTO>jugarMano(@PathVariable Long idPartida, @RequestBody ManoPeticionDTO manoPeticionDTO){
        ManoRespuestaDTO mano=partidaService.jugarMano(manoPeticionDTO,idPartida);
        if(Objects.isNull(mano)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el id de la partida o la mano son incorrectas");
        }
        return ResponseEntity.ok(mano);
    }

}
