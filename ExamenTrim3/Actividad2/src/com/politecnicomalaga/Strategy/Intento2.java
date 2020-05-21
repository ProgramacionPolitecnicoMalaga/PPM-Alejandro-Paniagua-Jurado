package com.politecnicomalaga.Strategy;

import com.politecnicomalaga.Modelo.ListaDeNiños;

public class Intento2 implements SelectorDeIntentosStrategy{
    @Override
    public String ElegirDeseo(ListaDeNiños listaDeNiños) {
        int posicion = -1;
        String cadena="";
        for (int i = 0; i < listaDeNiños.getTotalNiños(); i++) {
            cadena = listaDeNiños.getNiñoEnPosicion(i).getNombre() + " dice a un adulto: ¡Quiero " +listaDeNiños.getNiñoEnPosicion(i).getDeseo() + "!";
        }
        return cadena;
    }
}
