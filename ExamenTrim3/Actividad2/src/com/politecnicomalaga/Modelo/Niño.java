package com.politecnicomalaga.Modelo;

public class Niño {
    private String nombre;
    private String deseo;

    public Niño( String nombre, String deseo){
        this.nombre = nombre;
    }


    public String conseguirDeseo(int intento){
        if (intento == 1)
            return "intenta coger " + deseo + " sin que le vean";
        else if (intento == 2)
            return "dice a un adulto: ¡Quiero " + deseo + "!";
        else if (intento == 3)
            return "pone cara de pena y decir a un adulto " + deseo;
        else if (intento == 4)
            return "llora y grita a un adulto ¡" + deseo + "!";
        else
            return "se va a un rincón a llorar";
    }

    public String getNombre() {
        return nombre;
    }

}
