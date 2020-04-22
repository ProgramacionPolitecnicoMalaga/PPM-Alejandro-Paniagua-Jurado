package com.politecnicomalaga.Pack;

import com.politecnicomalaga.Builder.TipoPack;

public class Pack {
    private TipoPack tipo = null;
    private boolean Desayuno= false;
    private boolean Almuerzo= false;
    private boolean Cena= false;
    private boolean Habitación_simple= false;
    private boolean Habitación_doble= false;
    private boolean Habitación_suite= false;
    private boolean Cama_adicional= false;
    private boolean Parque_atracciones= false;
    private boolean Curso_surf= false;
    private boolean Actividades_infantiles= false;
    private boolean Cine_en_playa= false;

    public void setTipo(TipoPack tipo) {
        this.tipo = tipo;
    }

    public void setDesayuno() {
        Desayuno = true;
    }

    public void setAlmuerzo() {
        Almuerzo = true;
    }

    public void setCena() {
        Cena = true;
    }

    public void setHabitación_simple() {
        Habitación_simple = true;
    }

    public void setHabitación_doble() {
        Habitación_doble = true;
    }

    public void setHabitación_suite() {
        Habitación_suite = true;
    }

    public void setCama_adicional() {
        Cama_adicional = true;
    }

    public void setParque_atracciones() {
        Parque_atracciones = true;
    }

    public void setCurso_surf() {
        Curso_surf = true;
    }

    public void setActividades_infantiles() {
        Actividades_infantiles = true;
    }

    public void setCine_en_playa() {
        Cine_en_playa = true;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "tipo=" + tipo +
                ", Desayuno=" + Desayuno +
                ", Almuerzo=" + Almuerzo +
                ", Cena=" + Cena +
                ", Habitación_simpledoble=" + Habitación_simple +
                ", Habitación_doble=" + Habitación_doble +
                ", Habitación_suite=" + Habitación_suite +
                ", Cama_adicional=" + Cama_adicional +
                ", Parque_atracciones=" + Parque_atracciones +
                ", Curso_surf=" + Curso_surf +
                ", Actividades_infantiles=" + Actividades_infantiles +
                ", Cine_en_playa=" + Cine_en_playa +
                '}';
    }
}
