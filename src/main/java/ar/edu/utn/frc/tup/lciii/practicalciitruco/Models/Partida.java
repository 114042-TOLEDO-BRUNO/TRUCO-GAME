package ar.edu.utn.frc.tup.lciii.practicalciitruco.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partida {

    private Long id;
    private Mazo mazo;
    private List<Carta> cartasJugador1;
    private List<Carta> cartasJugador2;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador proximoEnJugar;
    private Jugador ganador;
    private PuntosEnJuego puntosEnJuego;
    private EstadoPartida estadoPartida;
    private Mano manoEnjuego;
    //private Integer ultimaCartaIndex;

}
