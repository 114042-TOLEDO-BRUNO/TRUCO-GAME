package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManoRespuestaDTO {

    @JsonProperty("jugadorId")
    private Long jugadorId;
    @JsonProperty("decision")
    private DecisionDeLaMano decision;
    @JsonProperty("mi_carta_jugada")
    private Carta miCartaJugada;
    @JsonProperty("carta_oponente_jugada")
    private Carta cartaOponenteJugada;

    @JsonProperty("jugador_gana_mano")
    private Jugador jugadorGanaMano;
    @JsonProperty("estado_partida")
    private EstadoPartida estadoPartida;
}
