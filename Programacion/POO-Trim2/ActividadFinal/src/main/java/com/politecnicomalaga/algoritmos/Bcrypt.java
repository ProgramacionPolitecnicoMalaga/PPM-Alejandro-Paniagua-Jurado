package com.politecnicomalaga.algoritmos;

import com.politecnicomalaga.control.GestorUsuarios;
import com.politecnicomalaga.modelo.Usuario;
import org.mindrot.jbcrypt.BCrypt;

public class Bcrypt implements Encriptador {

    public String getSalt() {
        return BCrypt.gensalt(12);
    }

    public String getContraseñaHash(String contraseña, String salt) {
        return BCrypt.hashpw(contraseña,salt);
    }

    public boolean comprobarContraseña(String contraseña, String contraseñaHash) {
        return BCrypt.checkpw(contraseña,contraseñaHash);
    }

    @Override
    public Usuario crearContraseña(String contraseña) {
        String salt = getSalt();
        return new Usuario(getContraseñaHash(contraseña,salt), GestorUsuarios.ALGORITMO_BCRYPT, salt);
    }

    @Override
    public boolean comprobarContraseña(String contraseña, Usuario usuario) {
        return comprobarContraseña(contraseña, usuario.getHash());
    }
}
