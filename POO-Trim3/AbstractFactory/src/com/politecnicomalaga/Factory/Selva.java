package com.politecnicomalaga.Factory;

import com.politecnicomalaga.Modelo.Jugador.Indiana;
import com.politecnicomalaga.Modelo.Jugador.Jugador;
import com.politecnicomalaga.Modelo.Jugador.USSEnterprise;
import com.politecnicomalaga.Modelo.Obstaculo.Carcelero_turco;
import com.politecnicomalaga.Modelo.Obstaculo.Obstaculo;
import com.politecnicomalaga.Modelo.Villano.Molaram;
import com.politecnicomalaga.Modelo.Villano.Villano;

public class Selva implements Personaje{
    @Override
    public Jugador crearJugador() {
        return new Indiana();
    }

    @Override
    public Villano crearVillano() {
        return new Molaram();
    }

    @Override
    public Obstaculo crearObstáculo() {
        return new Carcelero_turco();
    }
}
