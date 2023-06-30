package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.Impl;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities.JugadorEntity;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Jugador;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Repository.jpa.JugadorJpaRepository;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.LoginService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private JugadorJpaRepository jugadorJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Jugador login(String nombre, String password) {
        Optional<JugadorEntity> jugadorEntity=jugadorJpaRepository.findByNombreAndPassword(nombre,password);
        if(jugadorEntity.isPresent()){
            Jugador jugador=modelMapper.map(jugadorEntity,Jugador.class);
            return jugador;
        }else{
            throw new EntityNotFoundException("el jugador no se encuentra registrado");
        }
    }
}
