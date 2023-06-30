package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.login;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {

    @NotNull(message = "el nombre no puede ser nulo")
    @JsonProperty("nombre")
    private String nombre;

    @NotNull(message = "el password no puede ser nulo")
    @JsonProperty("password")
    private String password;
}
