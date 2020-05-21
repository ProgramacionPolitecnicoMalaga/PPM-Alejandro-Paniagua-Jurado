package com.politecnicomalaga.Strategy;

import com.politecnicomalaga.Modelo.ListaDeNiños;

public class Intento4 implements SelectorDeIntentosStrategy{
    @Override
    public String ElegirDeseo(ListaDeNiños listaDeNiños) {
        int posicion = -1;
        String cadena = "";
        for (int i = 0; i < listaDeNiños.getTotalNiños(); i++) {
            cadena = listaDeNiños.getNiñoEnPosicion(i).getNombre() + " llora y grita a un adulto ¡quiero " + listaDeNiños.getNiñoEnPosicion(i).getDeseo() + "!";
        }
        return cadena;
    }
}
