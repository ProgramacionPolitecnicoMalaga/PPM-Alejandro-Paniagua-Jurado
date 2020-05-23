package com.politecnicomalaga.Selector;

import com.politecnicomalaga.Modelo.LoteProductos;
import com.politecnicomalaga.Modelo.Producto;

public class SelectorRatio implements SelectorMejorProducto {
    @Override
    public Producto elegirMejorProducto(LoteProductos loteProductos) {
        Producto productoMejorRAtio= new Producto(1,1);
        for (Producto producto: loteProductos.getProductos())
            if (producto.getValoracion()/producto.getPrecio()> productoMejorRAtio.getValoracion()/productoMejorRAtio.getPrecio())
                productoMejorRAtio=producto;
        return productoMejorRAtio;
    }
}
