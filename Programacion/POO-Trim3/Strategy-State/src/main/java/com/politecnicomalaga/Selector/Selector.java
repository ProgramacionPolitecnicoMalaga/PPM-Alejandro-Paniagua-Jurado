package com.politecnicomalaga.Selector;

import com.politecnicomalaga.Modelo.LoteProductos;
import com.politecnicomalaga.Modelo.Producto;

public class Selector {
    private SelectorMejorProducto filtro;

    public void setFiltro(SelectorMejorProducto filtro){
        this.filtro=filtro;
    }
    public Producto getProducto(LoteProductos loteProductos){
        return filtro.elegirMejorProducto(loteProductos);
    }
}
