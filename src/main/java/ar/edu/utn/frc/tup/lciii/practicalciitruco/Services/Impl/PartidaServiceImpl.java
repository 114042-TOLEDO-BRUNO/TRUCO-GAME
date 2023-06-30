package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.Impl;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities.PartidaEntity;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.*;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Repository.jpa.PartidaJpaRepository;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.JugadorService;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.MazoService;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Services.PartidaService;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano.ManoPeticionDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano.ManoRespuestaDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida.NuevaPartidaPeticionDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida.PartidaRespuestaDTO;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class PartidaServiceImpl implements PartidaService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PartidaJpaRepository partidaJpaRepository;
    @Autowired
    private JugadorService jugadorService;
    @Autowired
    private MazoService mazoService;
    @Override
    public PartidaRespuestaDTO nuevaPartida(NuevaPartidaPeticionDTO nuevaPartidaPeticionDTO) {
        Jugador jugador1=jugadorService.getJugadorById(nuevaPartidaPeticionDTO.getJugador1Id());
        Jugador jugador2=jugadorService.getJugadorById(nuevaPartidaPeticionDTO.getJugador2Id());

        Partida partida=new Partida();

        partida.setJugador1(jugador1);
        partida.setJugador2(jugador2);

        Mazo mazo=mazoService.crearMazo();
        mazoService.mezclarMazo(mazo);
        partida.setMazo(mazo);
        partida.setCartasJugador1(mazoService.repartirCartas(mazo,1));
        partida.setCartasJugador2(mazoService.repartirCartas(mazo,2));
        partida.setProximoEnJugar(jugador1);
        partida.setGanador(null);
        partida.setEstadoPartida(EstadoPartida.JUGANDO);
        PuntosEnJuego puntosEnJuegoInicial=new PuntosEnJuego();
        puntosEnJuegoInicial.setPuntos(0);
        partida.setPuntosEnJuego(puntosEnJuegoInicial);
        PartidaEntity partidaEntity=modelMapper.map(partida,PartidaEntity.class);
        PartidaEntity partidaGuardada=partidaJpaRepository.saveAndFlush(partidaEntity);
        return modelMapper.map(partidaGuardada,PartidaRespuestaDTO.class);
    }

    @Override
    public Partida getPartidaById(Long id) {
        PartidaEntity partidaEntity=partidaJpaRepository.getReferenceById(id);
        if(Objects.isNull(partidaEntity.getId())){
            throw new EntityNotFoundException("partida no encontrada");
        }
        Partida partida=modelMapper.map(partidaEntity,Partida.class);
        return partida;
    }

    @Override
    public PartidaRespuestaDTO getPartidaRespuestaDTOById(Long partidaId) {
        PartidaEntity partidaEntity=partidaJpaRepository.getReferenceById(partidaId);
        if(Objects.isNull(partidaEntity.getId())){
            throw new EntityNotFoundException("partida no encontrada");
        }
        PartidaRespuestaDTO partidaRespuestaDTO=modelMapper.map(partidaEntity,PartidaRespuestaDTO.class);
        return partidaRespuestaDTO;
    }

    @Override
    public ManoRespuestaDTO jugarMano(ManoPeticionDTO manoPeticionDTO, Long partidaId) {
        ManoRespuestaDTO manoRespuestaDTO=new ManoRespuestaDTO();
        Partida partida=this.getPartidaById(partidaId);
        if(Objects.isNull(partida.getId())){
            throw new EntityNotFoundException("no se encontro la partida");
        }
        if(partida.getJugador1()==null&&partida.getJugador2()==null){
            throw new EntityNotFoundException("no se cargaron los jugadores a la partida");
        }
        if(partida.getEstadoPartida()==EstadoPartida.FINALIZADO){
            throw new EntityNotFoundException("EL JUEGO YA FINALIZO!!");
        }
        if(!manoPeticionDTO.getJugadorId().equals(partida.getProximoEnJugar().getId())){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400),"No es el turno del jugador "+partida.getProximoEnJugar().getNombre());
        }
        String carta=partida.getCartasJugador1().get(0).toString();
    }
}
