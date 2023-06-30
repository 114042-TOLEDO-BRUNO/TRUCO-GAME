package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services;


import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Carta;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Mazo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MazoService {

    Mazo crearMazo();

    void mezclarMazo(Mazo mazo);

    List<Carta> repartirCartas(Mazo mazo, Integer numeroJugador);
}
