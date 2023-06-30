package ar.edu.utn.frc.tup.lciii.practicalciitruco.Models;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PuntosEnJuego {
    private Integer puntos;
    private boolean truco=false;
    private boolean quieroRetruco=false;
    private boolean quieroValeCuatro=false;
    public void sumaDePuntos(Canto canto){
        if (canto.equals(Canto.TRUCO)){
            puntos++;
            truco = true;
        } else if (truco){
            if (canto.equals(Canto.QUIERORETRUCO)) {
                puntos++;
                quieroRetruco = true;
            } else if (quieroRetruco) {
                if (canto.equals(Canto.QUIEROVALECUATRO)) {
                    puntos++;
                    quieroValeCuatro = true;
                }
            }
        }
    }
}
