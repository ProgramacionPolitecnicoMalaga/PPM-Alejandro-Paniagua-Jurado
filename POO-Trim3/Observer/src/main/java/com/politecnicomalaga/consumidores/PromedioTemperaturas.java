package com.politecnicomalaga.consumidores;

import java.time.LocalTime;

public class PromedioTemperaturas implements ConsumidorDeTemperaturas {
    private int promedioTemperaturas;
    private int numeroTemperaturas;

    public PromedioTemperaturas() {
        promedioTemperaturas = 0;
        numeroTemperaturas = 0;
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        promedioTemperaturas= ((promedioTemperaturas*numeroTemperaturas)+temperatura)/(numeroTemperaturas+1);
        numeroTemperaturas++;
    }

    @Override
    public String toString() {
        return "El promedio de temperaturas de hoy es: " + promedioTemperaturas + "ºC\n";
    }
}
