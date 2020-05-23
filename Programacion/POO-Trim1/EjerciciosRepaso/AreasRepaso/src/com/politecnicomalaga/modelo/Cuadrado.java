package com.politecnicomalaga.modelo;

public class Cuadrado extends Figura {
    private double lado;

    public Cuadrado(String color) {
        super(color);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }
}
