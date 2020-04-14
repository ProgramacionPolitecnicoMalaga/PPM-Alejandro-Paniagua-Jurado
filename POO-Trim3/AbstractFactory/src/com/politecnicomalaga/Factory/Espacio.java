package com.politecnicomalaga.Factory;

import com.politecnicomalaga.Modelo.Jugador.Jugador;
import com.politecnicomalaga.Modelo.Jugador.USSEnterprise;
import com.politecnicomalaga.Modelo.Obstaculo.Naves_Klingon;
import com.politecnicomalaga.Modelo.Obstaculo.Obstaculo;
import com.politecnicomalaga.Modelo.Villano.Khan;
import com.politecnicomalaga.Modelo.Villano.Villano;

public class Espacio implements Personaje {
    @Override
    public Jugador crearJugador() {
        return new USSEnterprise();
    }
    @Override
    public Villano crearVillano() {
        return new Khan();
    }

    @Override
    public Obstaculo crearObstáculo() {
        return new Naves_Klingon();
    }
}
