package com.politecnicomalaga.Selector;

import com.politecnicomalaga.Modelo.LoteProductos;
import com.politecnicomalaga.Modelo.Producto;

public interface SelectorMejorProducto {
    public final static int SELECTOR_PRECIO = 1;
    public final static int SELECTOR_VALORACION = 2;
    public final static int SELECTOR_PRECIO_VALORACION = 3;

    public Producto elegirMejorProducto(LoteProductos loteProductos);
}
