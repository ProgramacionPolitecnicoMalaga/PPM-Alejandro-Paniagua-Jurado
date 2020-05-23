package com.politecnicomalaga.vista;

import com.politecnicomalaga.control.GestorUsuarios;
import com.politecnicomalaga.modelo.Usuario;
import com.politecnicomalaga.modelo.Validacion;

public class ValidacionDatos {

    public static Validacion comprobarDatos(DataTransfer dataTransfer) {
        GestorUsuarios gestorUsuarios = (GestorUsuarios) dataTransfer.get("gestorUsuarios");
        String nombre = (String) dataTransfer.get("nombre");
        String contraseña = (String) dataTransfer.get("contraseña");
        Usuario usuario = gestorUsuarios.getUsuarioPorNombre(nombre);
        return new Validacion(usuario, contraseña, gestorUsuarios.comprobarUsuario(nombre, contraseña));
    }
}
