package com.politecnicomalaga.Strategy;

import com.politecnicomalaga.Modelo.ListaDeDeseos;
import com.politecnicomalaga.Modelo.Niño;

public class Intento1 implements SelectorDeIntentosStrategy{

    @Override
    public Niño ejecutarIntento(ListaDeDeseos listaDeDeseos) {
        return "intenta coger " +  + " sin que le vean";;
    }
}
