package com.politecnicomalaga.Builder;

import com.politecnicomalaga.Composite.Paquete;
import com.politecnicomalaga.Composite.Producto;
import com.politecnicomalaga.Composite.Servicio;

public class Builder {
    private Builder padre;
    private Paquete paquete;

    public Builder(Paquete paquete) {
        this.padre = null;
        this.paquete = paquete;
    }

    public Builder(Builder padre, Paquete paquete) {
        this.padre = padre;
        this.paquete = paquete;
    }
    public Builder initPaquete(String nombre, double precio){
        Paquete newPaquete = new Paquete(nombre, precio);
        this.paquete.addServicio(newPaquete);
        return new Builder(this,newPaquete);
    }
    public Builder getPadre(){
        return padre;
    }
    public Builder addProducto(String nombre, double precio){
        paquete.addServicio(new Producto(nombre, precio));
        return this;
    }
    public Servicio getResultado(){
        return paquete;
    }
}
