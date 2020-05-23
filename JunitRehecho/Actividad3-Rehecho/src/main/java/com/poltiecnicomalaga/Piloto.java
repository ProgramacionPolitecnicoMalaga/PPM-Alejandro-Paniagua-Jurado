package com.poltiecnicomalaga;

public class Piloto {
    private int numero;
    private String nombre;

    public Piloto(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "numero=" + numero +
                ", nombre='" + nombre + '\'' +
                '}';
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piloto that = (Piloto) o;
        return numero == that.numero;
    }
}
