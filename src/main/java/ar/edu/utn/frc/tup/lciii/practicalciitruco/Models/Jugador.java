package ar.edu.utn.frc.tup.lciii.practicalciitruco.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {

    private Long id;
    private String nombre;
    private String password;
    private String email;
    private String avatar;
    private BigDecimal puntaje;

}
