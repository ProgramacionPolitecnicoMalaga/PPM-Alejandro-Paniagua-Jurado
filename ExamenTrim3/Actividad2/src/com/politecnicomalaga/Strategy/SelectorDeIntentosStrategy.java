package com.politecnicomalaga.Strategy;

import com.politecnicomalaga.Modelo.ListaDeDeseos;
import com.politecnicomalaga.Modelo.Niño;

public interface SelectorDeIntentosStrategy {
    int INTENTO_1 = 1;
    int INTENTO_2 = 2;
    int INTENTO_3 = 3;
    int INTENTO_4 = 3;

    Niño ElegirDeseo (Niño deseo);
}
