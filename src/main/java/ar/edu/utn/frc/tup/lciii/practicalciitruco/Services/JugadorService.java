package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Jugador;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador.JugadorRespuestaDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador.NuevoJugadorPeticionDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public interface JugadorService {
    JugadorRespuestaDTO getJugadorRespuestaDTOById(Long id);

    Jugador getJugadorById(Long id);

    Jugador actualizarPuntaje(Jugador jugador, BigDecimal nuevoPuntaje);

    JugadorRespuestaDTO getJugadorByNombreAndPassword(String nombre, String password);

    JugadorRespuestaDTO guardarJugador(NuevoJugadorPeticionDTO nuevoJugadorPeticionDTO);
}
