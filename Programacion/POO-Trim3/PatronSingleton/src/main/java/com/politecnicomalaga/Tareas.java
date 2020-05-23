package com.politecnicomalaga;

import java.util.ArrayList;

public class Tareas {
    private static Tareas instancia = null;

    private ArrayList<String> tareas;
    private int ultimaRealizada=0;

    public Tareas(){
        tareas = new ArrayList<>();
    }

    public static Tareas getInstance(){
        if (instancia == null)
            instancia = new Tareas();
        return instancia;
    }

    public void addTarea(String tarea) {
        tareas.add(tarea);
    }

    public void cambiarÚltimaTareaRealizada(int posicionNueva) {
        ultimaRealizada += posicionNueva;
    }
    public String getÚltimaTareaRealizada() {
        return tareas.get(ultimaRealizada);
    }
    public ArrayList<String> getListaTareas(){
        return tareas;
    }
}
