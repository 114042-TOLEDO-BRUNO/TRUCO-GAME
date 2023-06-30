package ar.edu.utn.frc.tup.lciii.practicalciitruco.Repository.jpa;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities.PartidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PartidaJpaRepository extends JpaRepository<PartidaEntity,Long> {
    @Query("SELECT pe FROM PartidaEntity pe WHERE pe.jugador1.id = :jugadorId OR pe.jugador2.id = :jugadorId")
    Optional<List<PartidaEntity>> getAllByPlayerOneOrPlayerTwo(Long jugadorId);
}
