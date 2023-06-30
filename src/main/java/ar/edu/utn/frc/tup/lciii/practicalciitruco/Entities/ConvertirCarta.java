package ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities;


import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Carta;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Palo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;

@Converter
public class ConvertirCarta implements AttributeConverter<Carta, String> {
    @Override
    public String convertToDatabaseColumn(Carta attribute) {
        return attribute.toString();
    }

    @Override
    public Carta convertToEntityAttribute(String dbData) {
        String [] cartaMap = dbData.split("_");
        return new Carta(
                Palo.valueOf(cartaMap[0]),
                Integer.valueOf(cartaMap[1]),
                new BigDecimal(cartaMap[2]));
    }
}
