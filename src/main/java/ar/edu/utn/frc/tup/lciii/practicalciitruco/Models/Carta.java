package ar.edu.utn.frc.tup.lciii.practicalciitruco.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carta {

    private Palo palo;
    private Integer numero;
    private BigDecimal valor;

    @Override
    public String toString() {
        return palo.toString() + "_" + numero + "_" + valor;
    }
}
