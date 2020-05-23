package com.politecnicomalaga.sensor;

import com.politecnicomalaga.consumidores.ConsumidorDeTemperaturas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

public class SensorTemperatura extends SensorTimerTask implements FuenteDeTEmperaturas {

    private int sensor;
    private Random aleatorio;
    private Instant inicio;
    private List<ConsumidorDeTemperaturas> consumidores;

    public SensorTemperatura() {
        aleatorio = new Random();
        inicio = Instant.now();
        consumidores = new ArrayList<>();
    }

    public void nuevaLectura() {
        sensor = aleatorio.ints(40, 200).limit(1).findFirst().getAsInt();
        Instant ahora = Instant.now();
        Duration period = Duration.between(inicio, ahora);
        informarAConsumidores();
        System.out.println("Lectura de temperatura: " + sensor + "ºC (" + period.getSeconds() + " segundos desde el inicio)");
        for (int i = 0; i < consumidores.size(); i++) {
            System.out.println(consumidores.get(i));
        }
    }

    @Override
    public void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas) {
        consumidores.add(consumidorDeTemperaturas);
    }

    @Override
    public void informarAConsumidores() {
        for (int i = 0; i < consumidores.size(); i++) {
            consumidores.get(i).setNuevaTemperatura(sensor, LocalTime.now());
        }
    }
}
