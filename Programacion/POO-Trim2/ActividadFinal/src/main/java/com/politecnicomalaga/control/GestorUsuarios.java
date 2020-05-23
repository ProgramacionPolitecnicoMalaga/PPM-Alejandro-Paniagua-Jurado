package com.politecnicomalaga.control;

import com.politecnicomalaga.algoritmos.Encriptador;
import com.politecnicomalaga.algoritmos.EncriptadorFactory;
import com.politecnicomalaga.dao.UsuarioDAO;
import com.politecnicomalaga.modelo.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class GestorUsuarios {

    private UsuarioDAO usuarioDAO;
    private Encriptador encriptador;

    public final static String ALGORITMO_BCRYPT = "BCrypt";
    public final static String ALGORITMO_SHA512 = "SHA-512";

    public GestorUsuarios() {
        try {
            usuarioDAO = new UsuarioDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario getUsuarioPorNombre(String nombre) {
        return usuarioDAO.getUsuarioPorNombre(nombre);
    }

    public void eliminarUsuario(ArrayList<String> nombresUsuarios) {
        for (String nombreUsuario: nombresUsuarios) {
            Usuario usuario = getUsuarioPorNombre(nombreUsuario);
            try {
                usuarioDAO.borrarUsuario(usuario);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Usuario encriptarContraseña(String contraseña, String algoritmo) {
        encriptador = EncriptadorFactory.obtenerEncriptador(algoritmo);
        return encriptador.crearContraseña(contraseña);
    }

    public void crearUsuario(String nombre, String contraseña, String algoritmo) {
        try {
            Usuario usuario = encriptarContraseña(contraseña, algoritmo);
            usuario.setNombre(nombre);
            usuarioDAO.crearUsuario(usuario);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean comprobarUsuario(String nombre, String contraseña) {
        Usuario usuario = getUsuarioPorNombre(nombre);
        encriptador = EncriptadorFactory.obtenerEncriptador(usuario.getAlgoritmo());
        return encriptador.comprobarContraseña(contraseña, usuario);
    }

    public boolean usuarioExistente(String nombre) {
        return getUsuarioPorNombre(nombre) != null;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return usuarioDAO.getListaUsuarios();
    }
}
