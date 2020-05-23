package com.politecnicomalaga.consumidores;

import com.politecnicomalaga.RegistroModelo.Registro;

import java.time.LocalTime;
import java.util.ArrayList;

public class PromedioTemperaturas implements ConsumidorDeTemperaturas {
    private ArrayList<Registro> registros;
    private int promedio;

    public PromedioTemperaturas() {
        registros=new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        registros.add(new Registro(temperatura,hora));
        for(int i = 0; i < registros.size(); i++){
            promedio+=registros.get(i).getTemperatura();
        }
        promedio=promedio/registros.size();
    }

    @Override
    public String toString() {
        return "El promedio de temperaturas de hoy es: " + promedio + "ºC\n";
    }
}
