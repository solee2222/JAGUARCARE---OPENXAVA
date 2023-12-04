package com.uam.CLINICA.Calculadores;

import lombok.*;
import org.openxava.calculators.ICalculator;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Getter @Setter
public class HoraCalculador implements ICalculator {

    @Override
    public Object calculate() throws Exception {
        LocalTime horaActual = LocalTime.now();// Obtener la hora actual
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        return horaActual.format(formato);// Formatea la hora actual como una cadena
    }

}
