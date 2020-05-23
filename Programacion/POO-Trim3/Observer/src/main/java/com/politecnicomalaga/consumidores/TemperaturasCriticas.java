package com.politecnicomalaga.consumidores;

import com.politecnicomalaga.RegistroModelo.Registro;

import java.time.LocalTime;
import java.util.ArrayList;

public class TemperaturasCriticas implements ConsumidorDeTemperaturas{
    private ArrayList<Registro> temperaturasCriticas;

    public TemperaturasCriticas() {
        temperaturasCriticas = new ArrayList<>();
    }

    @Override
    public void setNuevaTemperatura(int temperatura, LocalTime hora) {
        if (temperatura> 120)
            temperaturasCriticas.add(new Registro(temperatura, hora));
    }

    @Override
    public String toString() {
        String texto;
        texto = "Temperaturas críticas de hoy:\n";
        for(int i = 0; i <temperaturasCriticas.size(); i++){
            texto += temperaturasCriticas.get(i).getHora() + " - " + temperaturasCriticas.get(i).getTemperatura() + "ºC\n";
        }
        return texto;
    }
}
