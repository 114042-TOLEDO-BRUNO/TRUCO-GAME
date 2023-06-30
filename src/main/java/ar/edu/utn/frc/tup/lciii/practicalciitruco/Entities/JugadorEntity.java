package ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "jugadores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String avatar;

    @Column
    private BigDecimal puntaje;

}
