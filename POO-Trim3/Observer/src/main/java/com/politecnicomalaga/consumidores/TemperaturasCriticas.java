package com.politecnicomalaga.consumidores;

import java.time.LocalTime;
import java.util.ArrayList;

public class TemperaturasCriticas implements ConsumidorDeTemperaturas{
    private ArrayList<LocalTime> temperaturasCriticas;
    private final static int TEMPERATURA_CRITICA=100;

    public TemperaturasCriticas() {
        temperaturasCriticas = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        if (temperatura> TEMPERATURA_CRITICA)
            temperaturasCriticas.add(hora);
    }

    @Override
    public String toString() {
        String texto = "Las horas a las que se alcanzaron temperaturas críticas fueron:\n";
        for (LocalTime horaCritica: temperaturasCriticas)
            texto += horaCritica + "\n";
        return texto;
    }
}
