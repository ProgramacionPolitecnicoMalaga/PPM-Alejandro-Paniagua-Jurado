package com.politecnicomalaga.Modelo;

import com.politecnicomalaga.Factory.SelectorDeIntentos;
import com.politecnicomalaga.Strategy.SelectorDeIntentosStrategy;

import java.util.ArrayList;

public class ListaDeNiños {
    private ArrayList<Niño> niños;
    private SelectorDeIntentosStrategy selectorDeIntentosStrategy;

    public ListaDeNiños(){
        niños = new ArrayList<>();
    }
    public int getTotalNiños(){
        return niños.size();
    }


    public void addNiño(Niño niño){
        niños.add(niño);
    }

    public void setSelectorDeIntento(SelectorDeIntentosStrategy selectorDeIntento){
        this.selectorDeIntentosStrategy = selectorDeIntento;
    }
    public Niño getNiñoEnPosicion(int i){
        return niños.get(i);
    }

    @Override
    public String toString() {
        return "Niños " + niños;
    }
}
