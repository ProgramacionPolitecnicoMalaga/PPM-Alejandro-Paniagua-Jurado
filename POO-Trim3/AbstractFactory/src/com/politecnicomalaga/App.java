package com.politecnicomalaga;

import com.politecnicomalaga.Factory.Personaje;
import com.politecnicomalaga.Modelo.Jugador.Jugador;
import com.politecnicomalaga.Modelo.Obstaculo.Obstaculo;
import com.politecnicomalaga.Modelo.Villano.Villano;
import com.politecnicomalaga.Vista.SelectorDeJuego;

public class App {
    public static void main(String[] args) {
        SelectorDeJuego selectorJuego = new SelectorDeJuego();
        Personaje personajeFactory = selectorJuego.inicializarEscenario();

        Jugador jugador = personajeFactory.crearJugador();
        Villano villano = personajeFactory.crearVillano();
        Obstaculo obstáculo = personajeFactory.crearObstáculo();

        System.out.println("Jugador: " + jugador.getNombre());
        System.out.println("Villano: " + villano.getNombre());
        System.out.println("Obstáculo: " + obstáculo.getNombre());
    }
}
