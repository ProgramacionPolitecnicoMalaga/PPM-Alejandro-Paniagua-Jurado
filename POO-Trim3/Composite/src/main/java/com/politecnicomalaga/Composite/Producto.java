package com.politecnicomalaga.Composite;

public class Producto implements Servicio {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public void setPrecio(double precio) {
        this.precio=precio;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public int getTipo() {
        return Servicio.TIPO_PRODUCTO;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
