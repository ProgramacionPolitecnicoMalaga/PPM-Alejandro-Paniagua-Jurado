package com.politecnicomalaga;

import com.politecnicomalaga.consumidores.PromedioTemperaturas;
import com.politecnicomalaga.consumidores.RegistroDiario;
import com.politecnicomalaga.consumidores.TemperaturasCriticas;
import com.politecnicomalaga.sensor.SensorTemperatura;

import java.util.Timer;

public class App {
    public static void main(String[] args) {
        Timer temporizador = new Timer();
        SensorTemperatura sensor = new SensorTemperatura();
        temporizador.schedule(sensor,0,5000);
        RegistroDiario registroDiario = new RegistroDiario();
        PromedioTemperaturas promedioDeTemperaturas = new PromedioTemperaturas();
        TemperaturasCriticas TemperaturasCriticas = new TemperaturasCriticas();
        sensor.registrarConsumidor(registroDiario);
        sensor.registrarConsumidor(promedioDeTemperaturas);
        sensor.registrarConsumidor(TemperaturasCriticas );

    }
}
