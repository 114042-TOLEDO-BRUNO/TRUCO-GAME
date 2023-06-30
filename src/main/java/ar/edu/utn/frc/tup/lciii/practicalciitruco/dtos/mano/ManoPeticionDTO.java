package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano;


import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Palo;
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
public class ManoPeticionDTO {

    @NotNull
    @JsonProperty("jugadorId")
    private Long jugadorId;


    @JsonProperty(namespace = "Palo")
    private Palo palo;


    @JsonProperty(namespace = "numero")
    private Integer numero;

    @NotNull
    @JsonProperty(namespace = "decision")
    private Integer decision;

}
