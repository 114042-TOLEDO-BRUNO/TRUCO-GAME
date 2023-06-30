package ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Carta;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.DecisionDeLaMano;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Jugador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="manos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "partida_id", nullable=false)
    private PartidaEntity partidaId;
    @JoinColumn(name="mano_jugador")
    @ManyToOne
    private Jugador manoJugador;
    @Column
    @Enumerated(EnumType.STRING)
    private DecisionDeLaMano decisionDeLaMano;

    @Column(name = "carta_jugada")
    private Carta cartaJugada;

}
