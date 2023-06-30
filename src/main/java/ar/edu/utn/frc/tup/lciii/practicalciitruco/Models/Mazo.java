package ar.edu.utn.frc.tup.lciii.practicalciitruco.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mazo {

    private List<Carta> cartas;

}
