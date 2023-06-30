package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida;


import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.EstadoPartida;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador.JugadorRespuestaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaRespuestaDTO {

    private Long id;
    private JugadorRespuestaDTO jugador1;
    private JugadorRespuestaDTO jugador2;
    private JugadorRespuestaDTO proximoJugador;
    private JugadorRespuestaDTO ganador;
    private EstadoPartida estadoPartida;
}
