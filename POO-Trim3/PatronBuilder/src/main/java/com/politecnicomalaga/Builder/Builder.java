package com.politecnicomalaga.Builder;

import com.politecnicomalaga.Pack.Pack;

public class Builder {
    private Pack pack;
    public Builder(){
        pack=new Pack();
    }
    public Builder setTipo(TipoPack tipo){
        pack.setTipo(tipo);
        return this;
    }

    public Builder addDesayuno(){
        pack.setDesayuno();
        return this;
    }

    public Builder addAlmuerzo(){
        pack.setAlmuerzo();
        return this;
    }

    public Builder addCena(){
        pack.setCena();
        return this;
    }

    public Builder addHabitaciónSimple(){
        pack.setHabitación_simple();
        return this;
    }

    public Builder addHabitacionDoble() {
        pack.setHabitación_doble();
        return this;
    }

    public Builder addHabitacionSuite(){
        pack.setHabitación_suite();
        return this;
    }

    public Builder addACamaAdicional(){
        pack.setCama_adicional();
        return this;
    }

    public Builder addParqueAtracciones(){
        pack.setParque_atracciones();
        return this;
    }

    public Builder addCursoKiteSurf(){
        pack.setCurso_surf();
        return this;
    }

    public Builder addActividadesInfantiles() {
        pack.setActividades_infantiles();
        return this;
    }

    public Builder addCinePlaya() {
        pack.setCine_en_playa();
        return this;
    }

    public Pack getResultado(){
        return pack;
    }
}
