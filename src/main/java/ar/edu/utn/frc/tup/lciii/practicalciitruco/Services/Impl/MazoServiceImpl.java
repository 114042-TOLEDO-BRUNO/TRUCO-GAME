package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.Impl;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Carta;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Mazo;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Palo;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.MazoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class MazoServiceImpl implements MazoService {

    @Override
    public Mazo crearMazo() {
        Mazo mazo = new Mazo(new ArrayList<>());
        for(Palo palo :Palo.values()) {
            for(int i = 1; i < 13; i++) {
                mazo.getCartas().add(new Carta(palo, i, BigDecimal.valueOf(i)));
            }
        }
        return mazo;
    }

    @Override
    public void mezclarMazo(Mazo mazo) {
        Collections.shuffle(mazo.getCartas());
    }

    @Override
    public List<Carta> repartirCartas(Mazo mazo, Integer numeroJugador) {
        List<Carta> cartaList = new ArrayList<>();
        if (numeroJugador==1){
            cartaList.add(mazo.getCartas().get(0));
            cartaList.add(mazo.getCartas().get(2));
            cartaList.add(mazo.getCartas().get(4));
            return cartaList;
        } else {
            cartaList.add(mazo.getCartas().get(1));
            cartaList.add(mazo.getCartas().get(3));
            cartaList.add(mazo.getCartas().get(5));
            return cartaList;
        }
    }
}
