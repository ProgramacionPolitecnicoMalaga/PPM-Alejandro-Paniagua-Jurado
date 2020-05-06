package com.politecnicomalaga.consumidores;

import java.time.LocalTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RegistroDiario implements ConsumidorDeTemperaturas {
    private TreeMap<LocalTime, Integer> temperaturasPorHoras;

    public RegistroDiario() {
        temperaturasPorHoras = new TreeMap<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        temperaturasPorHoras.put(hora, temperatura);
    }

    @Override
    public String toString() {
        StringBuilder texto = new StringBuilder("Temperaturas de hoy:\n");
        Set<Map.Entry<LocalTime, Integer>> datos = temperaturasPorHoras.entrySet();
        datos.forEach( entry -> texto.append("A las ").append(entry.getKey()).append(" se registró una temperatura de ").append(entry.getValue()).append("ºC\n"));
        return texto.toString();
    }
}
