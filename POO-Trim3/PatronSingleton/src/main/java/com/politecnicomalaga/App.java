package com.politecnicomalaga;

public class App {
    public static void main(String[] args) {
        Tareas tareas = Tareas.getInstance();
        AvanceTarea avanceTarea = new AvanceTarea();
        RetrocesoTarea retrocesoTarea = new RetrocesoTarea();

        tareas.addTarea("Tarea 1");
        tareas.addTarea("Tarea 2");
        tareas.addTarea("Tarea 3");
        tareas.addTarea("Tarea 4");

        System.out.println(tareas.getÚltimaTareaRealizada());

        retrocesoTarea.retroceder(2);
        System.out.println(tareas.getÚltimaTareaRealizada());

        retrocesoTarea.retroceder(1);
        System.out.println(tareas.getÚltimaTareaRealizada());

        avanceTarea.avanzar(1);
        System.out.println(tareas.getÚltimaTareaRealizada());

        avanceTarea.avanzar(1);
        System.out.println(tareas.getÚltimaTareaRealizada());
    }
}
