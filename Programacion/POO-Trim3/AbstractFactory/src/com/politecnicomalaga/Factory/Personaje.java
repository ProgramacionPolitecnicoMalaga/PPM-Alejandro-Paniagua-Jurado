package com.politecnicomalaga.Factory;

import com.politecnicomalaga.Modelo.Jugador.Jugador;
import com.politecnicomalaga.Modelo.Obstaculo.Obstaculo;
import com.politecnicomalaga.Modelo.Villano.Villano;

public interface Personaje {
    public Jugador crearJugador();
    public Villano crearVillano();
    public Obstaculo crearObstáculo();
}
