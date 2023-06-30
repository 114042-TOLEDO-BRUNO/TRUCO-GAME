package ar.edu.utn.frc.tup.lciii.practicalciitruco.Services;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Partida;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano.ManoPeticionDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.mano.ManoRespuestaDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida.NuevaPartidaPeticionDTO;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.partida.PartidaRespuestaDTO;
import org.springframework.stereotype.Service;

@Service
public interface PartidaService {
    PartidaRespuestaDTO nuevaPartida(NuevaPartidaPeticionDTO nuevaPartidaPeticionDTO);
    Partida getPartidaById(Long id);//solo usado para la implementacion del servicio pero no para el controlador
    PartidaRespuestaDTO getPartidaRespuestaDTOById(Long partidaId);
    ManoRespuestaDTO jugarMano(ManoPeticionDTO manoPeticionDTO, Long partidaId);
}
