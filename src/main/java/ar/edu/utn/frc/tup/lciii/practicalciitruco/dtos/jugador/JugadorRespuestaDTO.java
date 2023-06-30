package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JugadorRespuestaDTO {

    @JsonProperty("jugador")
    private String nombre;
    @JsonProperty("avatar")
    private String avatar;
    @JsonProperty("puntaje")
    private BigDecimal puntaje;
}
