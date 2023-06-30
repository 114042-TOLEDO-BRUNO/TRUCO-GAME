package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NuevaPartidaPeticionDTO {

    @NotNull
    private Long jugador1Id;

    @NotNull
    private Long jugador2Id;
}
