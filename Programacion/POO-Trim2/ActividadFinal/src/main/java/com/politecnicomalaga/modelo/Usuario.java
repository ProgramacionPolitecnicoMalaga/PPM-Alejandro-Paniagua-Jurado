package com.politecnicomalaga.modelo;

public class Usuario {
    private String nombre;
    private String hash;
    private String algoritmo;
    private String salt;

    public Usuario( String nombre, String hash, String algoritmo, String salt) {
        this.nombre = nombre;
        this.hash = hash;
        this.algoritmo = algoritmo;
        this.salt = salt;
    }

    public Usuario(String hash, String algoritmo, String salt) {
        this.hash = hash;
        this.algoritmo = algoritmo;
        this.salt = salt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHash() {
        return hash;
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public String getSalt() {
        return salt;
    }

    @Override
    public boolean equals(Object o) {
       Usuario that = (Usuario) o;
       return nombre.equals(that.nombre);
    }
}
