package com.politecnicomalaga.vista;
import com.politecnicomalaga.controlador.GestorUsuarios;
import com.politecnicomalaga.modelo.Usuario;
import com.politecnicomalaga.modelo.Validacion;

public class DataTransferAValidacion {

    public static Validacion transformar(DataTransfer datos){
        GestorUsuarios controlador = (GestorUsuarios) datos.get("controlador");
        String nombre = (String) datos.get("nombre");
        String contraseña = (String) datos.get("contraseña");
        Usuario usuario = controlador.getCredencialPorNombre(nombre);
        return new Validacion(usuario, contraseña, controlador.comprobarCredenciales(nombre, contraseña));
    }
}