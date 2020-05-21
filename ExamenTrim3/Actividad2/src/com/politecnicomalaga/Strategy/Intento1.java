package com.politecnicomalaga.Strategy;

import com.politecnicomalaga.Modelo.ListaDeNiños;
import com.politecnicomalaga.Modelo.Niño;

public class Intento1 implements SelectorDeIntentosStrategy {

    @Override
    public String ElegirDeseo(ListaDeNiños listaDeNiños) {
        int posicion = -1;
        String cadena="";
        for (int i = 0; i < listaDeNiños.getTotalNiños(); i++) {
            cadena = listaDeNiños.getNiñoEnPosicion(i).getNombre() + " intenta coger " + listaDeNiños.getNiñoEnPosicion(i).getDeseo() + " sin que le vean";
        }
        return cadena;
    }
}

