package ar.edu.utn.frc.tup.lciii.practicalciitruco.dtos.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class ErrorApi {

    private String timestamp;

    private Integer status;

    private String error;

    private String message;
}
