package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services;


import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Jugador;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    Jugador login(String nombre, String password);
}
