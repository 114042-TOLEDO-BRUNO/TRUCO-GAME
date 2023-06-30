package ar.edu.utn.frc.tup.lciii.practicalciitruco.Repository.jpa;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities.JugadorEntity;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities.PartidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface JugadorJpaRepository extends JpaRepository<JugadorEntity,Long> {
    Optional<JugadorEntity> findByNombreOrEmail(String nombre, String email);

    Optional<JugadorEntity> findByNombreOrPassword(String nombre, String password);

    Optional<JugadorEntity> findByNombreAndPassword(String email, String password);

    @Query("SELECT j FROM JugadorEntity j WHERE (j.nombre LIKE :identity OR j.email LIKE :identity) AND j.password LIKE :password")
    Optional<JugadorEntity> findByNombreOrEmailAndPassword(@Param("identity") String identity, @Param("password") String password);
}
