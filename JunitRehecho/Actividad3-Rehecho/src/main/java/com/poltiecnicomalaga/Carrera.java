package com.poltiecnicomalaga;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private ArrayList<Piloto> listaPilotos;
    boolean addParticipante(Piloto piloto){
        boolean añadido=false;
        if (!listaPilotos.contains(piloto)){
            listaPilotos.add(piloto);
            añadido=true;
        }
        return añadido;
    }
    List getListadoParticipantes(){
        List<Piloto> listado=listaPilotos;
        if (listaPilotos.isEmpty()){
            listado=null;
        }
        return listado;
    }
    int getTotalParticipantes(){
        return listaPilotos.size();
    }
    public List<String> cloneCarrera(){
        return (List<String>) listaPilotos.clone();
    }
    boolean setPosicion(String nombrePiloto, int posicionDestino){
        boolean validado=false;
        for (int i = 0; i < listaPilotos.size(); i++){
            if (listaPilotos.get(i).getNombre().equals(nombrePiloto)){
                Piloto piloto=listaPilotos.remove(i);
                listaPilotos.add(posicionDestino,piloto);
                validado=true;
            }
        }
        return validado;
    }
   public Piloto getParticipantePorPosicion(int posicion){
        return listaPilotos.get(posicion);
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "listaPilotos=" + listaPilotos +
                '}';
    }
}
