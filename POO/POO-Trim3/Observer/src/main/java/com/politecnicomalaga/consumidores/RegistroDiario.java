package com.politecnicomalaga.consumidores;

import com.politecnicomalaga.RegistroModelo.Registro;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class RegistroDiario implements ConsumidorDeTemperaturas {
    private ArrayList<Registro> temperaturasPorHoras;

    public RegistroDiario() {
        temperaturasPorHoras = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        temperaturasPorHoras.add(new Registro(temperatura, hora));
    }

    @Override
    public String toString() {
        String texto;
        texto = "Las temperaturas de hoy son:\n";
        for(int i = 0; i < temperaturasPorHoras.size(); i++){
            texto += temperaturasPorHoras.get(i).getHora() + " - " + temperaturasPorHoras.get(i).getTemperatura() + "ºC\n";
        }
        return texto;
    }
}
