package com.politecnicomalaga.Modelo;

public class Producto {
    double precio;
    int valoracion;

    public Producto(double precio, int valoracion) {
        this.precio = precio;
        this.valoracion = valoracion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getValoracion() {
        return valoracion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", valoracion=" + valoracion +
                '}';
    }
}
