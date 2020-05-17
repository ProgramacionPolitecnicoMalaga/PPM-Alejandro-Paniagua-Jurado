package com.politecnicomalaga;

import org.junit.Test;
import org.mockito.ArgumentMatcher;

import static org.junit.Assert.*;

public class GrupoSensores implements ArgumentMatcher<Integer> {
    private Integer minimo;
    private Integer maximo;

    public GrupoSensores(int estado) {
        switch (estado) {
            case Sensor.NO_INICIADO:
                minimo=0;
                maximo=9;
                break;
            case Sensor.ESTADO_VACIO:
                minimo=10;
                maximo=19;
                break;
            case Sensor.ESTADO_CASI_VACIO:
                minimo=20;
                maximo=29;
                break;
            case Sensor.ESTADO_MITAD:
                minimo=30;
                maximo=39;
                break;
            case Sensor.ESTADO_CASI_LLENO:
                minimo=40;
                maximo=49;
                break;
            case Sensor.ESTADO_LLENO:
                minimo=50;
                maximo=59;
                break;
        }
    }


    @Override
    public boolean matches(Integer integer) {
        return (integer >= minimo) && (integer <= maximo);
    }
}