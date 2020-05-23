package com.politecnicomalaga.dao;

import com.politecnicomalaga.modelo.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO {

    private DBConn conn;
    private ArrayList<Usuario> listaUsuarios;

    public UsuarioDAO() throws SQLException {
        conn = new DBConn();
        listaUsuarios = getListaDB();
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario getUsuarioPorNombre(String nombre) {
        for (Usuario usuario: listaUsuarios) {
            if (usuario.getNombre().toUpperCase().equals(nombre.toUpperCase())) {
                return usuario;
            }
        }
        return null;
    }

    //Creamos una lista con los usuarios de la tabla
    public ArrayList<Usuario> getListaDB() throws SQLException {
        ResultSet result = conn.read("SELECT nombre, hash, algoritmo, salt FROM Credenciales");
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        while (result.next()) {
            listaUsuarios.add(new Usuario (result.getString("nombre"), result.getString("hash"), result.getString("algoritmo"), result.getString("salt")));
        }
        return listaUsuarios;
    }

    //Añadimos usuarios
    public void crearUsuario(Usuario usuario) throws SQLException {
        conn.create("INSERT INTO Credenciales(nombre, hash, algoritmo, salt) VALUES ('" + usuario.getNombre() + "','" + usuario.getHash() + "','" + usuario.getAlgoritmo() + "','" +  usuario.getSalt()+ "')");
        listaUsuarios.add(usuario);

    }

    //Borramos usuarios
    public void borrarUsuario(Usuario usuario) throws SQLException {
        conn.delete("DELETE FROM Credenciales WHERE nombre = '" + usuario.getNombre() + "'");
        listaUsuarios.remove(usuario);
    }
}