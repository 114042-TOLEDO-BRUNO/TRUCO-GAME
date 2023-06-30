package ar.edu.utn.frc.tup.lciii.practicalciitruco.Entities;

import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Carta;
import ar.edu.utn.frc.tup.lciii.practicalciitruco.Models.Palo;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class ConvertirListaCartas implements AttributeConverter<List<Carta>, String> {

//    private static final String DELIMITER = ";";
//
//    @Override
//    public String convertToDatabaseColumn(List<Carta> attribute) {
//        StringBuilder sb = new StringBuilder();
//        for (Carta carta : attribute) {
//            sb.append(carta.toString()).append(DELIMITER);
//        }
//        return sb.toString();
//    }

//    @Override
//    public List<Carta> convertToEntityAttribute(String dbData) {
//        List<Carta> cartas = new ArrayList<>();
//        String[] cartaStrings = dbData.split(DELIMITER);
//        for (String cartaString : cartaStrings) {
//            String[] cartaMap = cartaString.split("_");
//            Carta carta = new Carta(
//                    Palo.valueOf(cartaMap[0]),
//                    Integer.valueOf(cartaMap[1]),
//                    new BigDecimal(cartaMap[2])
//            );
//            cartas.add(carta);
//        }
//        return cartas;


    private static final String SPLIT_CHAR = ";";

    @Override
    public String convertToDatabaseColumn(List<Carta> attribute) {
        if(attribute != null) {
            return attribute.stream().map(Carta::toString).collect(Collectors.joining(SPLIT_CHAR));
        } else {
            return "";
        }
    }

    @Override
    public List<Carta> convertToEntityAttribute(String dbData) {
        return new ArrayList<>(Arrays.stream(dbData.split(SPLIT_CHAR)).map(s -> {
            String [] cardMap = s.split("");
            return new Carta(
                    Palo.valueOf(cardMap[0]),
                    Integer.valueOf(cardMap[1]),
                    new BigDecimal(cardMap[2]));
        }).collect(Collectors.toList()));
    }
}