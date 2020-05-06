package com.politecnicomalaga.sensor;

import com.politecnicomalaga.consumidores.ConsumidorDeTemperaturas;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.TimerTask;

public class SensorTemperatura extends SensorTimerTask implements FuenteDeTEmperaturas{

    private int sensor;
    private Random aleatorio;
    private Instant inicio;

    public SensorTemperatura(){
        aleatorio = new Random();
        inicio = Instant.now();
    }

    public void nuevaLectura(){
        sensor = aleatorio.ints(40, 200).limit(1).findFirst().getAsInt();
        Instant ahora = Instant.now();
        Duration period = Duration.between(inicio,ahora);

        System.out.println("Lectura de temperatura: " + sensor +  "ºC (" + period.getSeconds() + " segundos desde el inicio)");
    }

    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas) {

    }

    @Override
    public void informarAConsumidores() {

    }
}
