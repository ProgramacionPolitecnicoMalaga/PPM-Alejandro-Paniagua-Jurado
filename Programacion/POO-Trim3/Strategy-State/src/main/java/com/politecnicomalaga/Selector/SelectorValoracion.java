package com.politecnicomalaga.Selector;

import com.politecnicomalaga.Modelo.LoteProductos;
import com.politecnicomalaga.Modelo.Producto;

public class SelectorValoracion implements SelectorMejorProducto {

    @Override
    public Producto elegirMejorProducto(LoteProductos loteProductos) {
        Producto productoMejorValorado=new Producto(1,1);
        for (Producto producto: loteProductos.getProductos())
            if (producto.getValoracion()> productoMejorValorado.getValoracion())
                productoMejorValorado=producto;
            return productoMejorValorado;
    }
}
