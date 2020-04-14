package com.politecnicomalaga.Factory;

import com.politecnicomalaga.Modelo.Jugador.Jugador;
import com.politecnicomalaga.Modelo.Jugador.Patton;
import com.politecnicomalaga.Modelo.Obstaculo.Obstaculo;
import com.politecnicomalaga.Modelo.Obstaculo.Tanques;
import com.politecnicomalaga.Modelo.Villano.Rommel;
import com.politecnicomalaga.Modelo.Villano.Villano;

public class Desierto implements Personaje {
    @Override
    public Jugador crearJugador() {
        return new Patton();
    }

    @Override
    public Villano crearVillano() {
        return new Rommel();
    }

    @Override
    public Obstaculo crearObstáculo() {
        return new Tanques();
    }
}
