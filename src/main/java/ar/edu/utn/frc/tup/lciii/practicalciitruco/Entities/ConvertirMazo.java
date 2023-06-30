package ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities;


import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Carta;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Mazo;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Palo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

@Converter
public class ConvertirMazo implements AttributeConverter<Mazo, String> {

    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(Mazo attribute) {
        if(attribute != null) {
            return attribute.getCartas().stream().map(Carta::toString).collect(Collectors.joining(SPLIT_CHAR));
        } else {
            return "";
        }
    }

    @Override
    public Mazo convertToEntityAttribute(String dbData) {
        return new Mazo(Arrays.stream(dbData.split(SPLIT_CHAR)).map(s -> {
            String [] cardMap = s.split("_");
            return new Carta(
                    Palo.valueOf(cardMap[0]),
                    Integer.valueOf(cardMap[1]),
                    new BigDecimal(cardMap[2]));
        }).collect(Collectors.toList()));
    }
}
