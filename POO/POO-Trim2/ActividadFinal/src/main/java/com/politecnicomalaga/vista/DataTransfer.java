package com.politecnicomalaga.vista;

import com.politecnicomalaga.control.GestorUsuarios;
import com.politecnicomalaga.modelo.Usuario;
import com.politecnicomalaga.modelo.Validacion;

import java.util.TreeMap;

public class DataTransfer {
    private TreeMap<String, Object> datos = new TreeMap<>();

    public void put(String clave, Object objeto){
        datos.put(clave, objeto);
    }

    public Object get(String clave){
        return datos.get(clave);
    }
}
