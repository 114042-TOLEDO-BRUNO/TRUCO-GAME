package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.Impl;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities.JugadorEntity;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Jugador;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Repository.jpa.JugadorJpaRepository;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.JugadorService;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador.JugadorRespuestaDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.jugador.NuevoJugadorPeticionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

@Service
public class JugadorServiceImpl implements JugadorService {
    @Autowired
    private JugadorJpaRepository jugadorJpaRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public JugadorRespuestaDTO getJugadorRespuestaDTOById(Long id) {
        JugadorEntity jugadorEntity=jugadorJpaRepository.getReferenceById(id);
        if(Objects.isNull(jugadorEntity.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El id numero "+id+" no existe en los registros");
        }
        return modelMapper.map(jugadorEntity,JugadorRespuestaDTO.class);
    }

    @Override
    public Jugador getJugadorById(Long id) {
        JugadorEntity jugadorEntity=jugadorJpaRepository.getReferenceById(id);
        if(Objects.isNull(jugadorEntity.getId())){
            throw new EntityNotFoundException("el jugador no existe");
        }
        return modelMapper.map(jugadorEntity,Jugador.class);
    }

    @Override
    public Jugador actualizarPuntaje(Jugador jugador, BigDecimal nuevoPuntaje) {
        JugadorEntity jugadorEntity=modelMapper.map(jugador,JugadorEntity.class);
        jugadorEntity.setPuntaje(nuevoPuntaje);
        JugadorEntity jugadorEntityGuardado=jugadorJpaRepository.saveAndFlush(jugadorEntity);
        return modelMapper.map(jugadorEntityGuardado,Jugador.class);
    }

    @Override
    public JugadorRespuestaDTO getJugadorByNombreAndPassword(String nombre, String password) {
        Optional<JugadorEntity> jugadorEntity=jugadorJpaRepository.findByNombreAndPassword(nombre,password);
        if(jugadorEntity.isPresent()){
            return modelMapper.map(jugadorEntity,JugadorRespuestaDTO.class);
        }
        throw new EntityNotFoundException("el jugador con el nombre " +nombre+" no fue encontrado");
    }

    @Override
    public JugadorRespuestaDTO guardarJugador(NuevoJugadorPeticionDTO nuevoJugadorPeticionDTO) {
        JugadorEntity jugadorEntity=modelMapper.map(nuevoJugadorPeticionDTO,JugadorEntity.class);
       if(jugadorJpaRepository.findByNombreOrEmail(jugadorEntity.getNombre(),jugadorEntity.getEmail()).isPresent()) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el jugador ya se encuentra registrado");
       }
       jugadorEntity.setPuntaje(new BigDecimal(0));
        JugadorEntity jugadorGuardado=jugadorJpaRepository.saveAndFlush(jugadorEntity);
        return modelMapper.map(jugadorGuardado,JugadorRespuestaDTO.class);
    }
}
