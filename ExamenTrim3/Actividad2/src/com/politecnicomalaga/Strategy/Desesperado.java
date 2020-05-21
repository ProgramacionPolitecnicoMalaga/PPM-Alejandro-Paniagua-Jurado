package com.politecnicomalaga.Strategy;

import com.politecnicomalaga.Modelo.ListaDeNiños;

public class Desesperado implements SelectorDeIntentosStrategy {
    @Override
    public String ElegirDeseo(ListaDeNiños listaDeNiños) {
        int posicion = -1;
        String cadena="";
        for (int i = 0; i < listaDeNiños.getTotalNiños(); i++) {
            cadena = listaDeNiños.getNiñoEnPosicion(i).getNombre() +" se va a un rincon a llorar ";
        }
        return cadena;
    }
}
