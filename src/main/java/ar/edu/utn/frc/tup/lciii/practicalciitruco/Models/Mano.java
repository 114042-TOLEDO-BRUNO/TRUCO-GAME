package ar.edu.utn.frc.tup.lciii.practicalciitruco.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mano {

    private Long id;
    private Long idPartida;
    private Jugador manoJugador;
    private DecisionDeLaMano decisionDeLaMano;
    private Carta cartaJugada;
}
