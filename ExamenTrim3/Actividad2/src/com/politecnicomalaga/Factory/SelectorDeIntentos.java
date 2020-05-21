package com.politecnicomalaga.Factory;

import com.politecnicomalaga.Strategy.*;

public class SelectorDeIntentos {
    public static SelectorDeIntentosStrategy getSelectorDeIntento(int criterio) {
        switch (criterio) {
            case SelectorDeIntentosStrategy.INTENTO_1:
                return new Intento1();
            case SelectorDeIntentosStrategy.INTENTO_2:
                return new Intento2();
            case SelectorDeIntentosStrategy.INTENTO_3:
                return new Intento3();
            case SelectorDeIntentosStrategy.INTENTO_4:
                return new Intento4();
            default:
                return new Intento1();
        }
    }
}
