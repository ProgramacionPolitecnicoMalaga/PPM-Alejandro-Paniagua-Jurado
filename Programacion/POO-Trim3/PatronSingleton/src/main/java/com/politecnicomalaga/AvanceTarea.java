package com.politecnicomalaga;

public class AvanceTarea {
    Tareas tareas = Tareas.getInstance();

    public void avanzar(int numero) {
        tareas.cambiarÚltimaTareaRealizada(numero);
        mostrarÚltimaTareaRealizada();
    }

    public String mostrarÚltimaTareaRealizada() {
        return tareas.getÚltimaTareaRealizada();
    }
}
