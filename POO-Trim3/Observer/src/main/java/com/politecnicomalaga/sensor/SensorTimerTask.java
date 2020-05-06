package com.politecnicomalaga.sensor;

import java.util.Random;
import java.util.TimerTask;

public abstract class SensorTimerTask extends TimerTask {
    Random aleatorio;

    public SensorTimerTask() {
        aleatorio = new Random();
    }

    public abstract void nuevaLectura();

    public void run() {
        if (hayLectura())
            nuevaLectura();

    }

    private boolean hayLectura() {
        return aleatorio.nextBoolean();
    }
}
