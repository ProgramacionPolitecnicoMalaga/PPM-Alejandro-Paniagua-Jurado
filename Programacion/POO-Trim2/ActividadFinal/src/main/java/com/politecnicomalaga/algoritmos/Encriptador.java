package com.politecnicomalaga.algoritmos;

import com.politecnicomalaga.modelo.Usuario;

public interface Encriptador {

    Usuario crearContraseña(String contraseña);
    boolean comprobarContraseña(String contraseña, Usuario usuario);
}
