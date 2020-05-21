package com.politecnicomalaga.Modelo;

public class Niño {
    private String nombre;
    private String deseo;

    public Niño( String nombre ,String deseo){
        this.nombre = nombre;
        this.deseo = deseo;
    }
    public String getDeseo(){
        return deseo;
    }

    public String getNombre() {
        return nombre;
    }
}
