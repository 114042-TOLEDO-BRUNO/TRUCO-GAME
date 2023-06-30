package ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "partidas")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartidaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Convert(converter = ConvertirMazo.class)
    @Column
    private Mazo mazo;
    @JoinColumn(name="jugador_1")
    @ManyToOne
    private JugadorEntity jugador1;

    @JoinColumn(name="jugador_2")
    @ManyToOne
    private JugadorEntity jugador2;

    @JoinColumn(name="proximo_jugador")
    @ManyToOne
    private JugadorEntity proximoJugador;

    @JoinColumn(name="ganador_id")
    @ManyToOne
    private JugadorEntity ganador;

    @Column(name="estado_partida")
    @Enumerated(EnumType.STRING)
    private EstadoPartida estadoPartida;
    @Embedded
    @Column(name="puntos_en_juego")
    private PuntosEnJuego puntosEnJuego;

    @Lob
    @Convert(converter = ConvertirListaCartas.class)
    @Column(name="lista_carta_jug_1")
    private List<Carta> listaCartasJugador1;

    @Lob
    @Convert(converter = ConvertirListaCartas.class)
    @Column(name="lista_carta_jug_2")
    private List<Carta> listaCartasJugador2;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "partidaId", cascade = CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    private List<ManoEntity> manoList;

}
