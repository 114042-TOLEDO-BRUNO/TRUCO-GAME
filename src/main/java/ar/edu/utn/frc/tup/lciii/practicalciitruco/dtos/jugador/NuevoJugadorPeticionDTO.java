package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NuevoJugadorPeticionDTO {

    @NotNull
    @JsonProperty("nombre")
    private String nombre;
    @NotNull
    @JsonProperty("password")
    private String password;

    @JsonProperty("email")
    private String email;

}
