package com.politecnicomalaga.sensor;

import com.politecnicomalaga.consumidores.ConsumidorDeTemperaturas;

public interface FuenteDeTEmperaturas {
    void registrarConsumidor(ConsumidorDeTemperaturas consumidorDeTemperaturas);
    void informarAConsumidores();
}
