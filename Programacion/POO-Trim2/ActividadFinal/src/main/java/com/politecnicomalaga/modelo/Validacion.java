package com.politecnicomalaga.modelo;

public class Validacion {

    private Usuario usuario;
    private String contraseña;
    private boolean correcto;

    public Validacion(Usuario usuario, String contraseña, boolean correcto) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correcto = correcto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public boolean isCorrecto() {
        return correcto;
    }
}
