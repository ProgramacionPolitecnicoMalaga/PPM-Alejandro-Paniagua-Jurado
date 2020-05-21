package com.politecnicomalaga.Strategy;

import com.politecnicomalaga.Modelo.ListaDeNiños;

public class Intento3 implements SelectorDeIntentosStrategy{
    @Override
    public String ElegirDeseo(String cadena, ListaDeNiños listaDeNiños) {
        int posicion = -1;
        for (int i = 0; i < listaDeNiños.getTotalNiños(); i++) {
            cadena = listaDeNiños.getNiñoEnPosicion(i).getNombre() +"pone cara de pena y decir a un adulto " + listaDeNiños.getNiñoEnPosicion(i).getDeseo();
        }
        return cadena;
    }
}
