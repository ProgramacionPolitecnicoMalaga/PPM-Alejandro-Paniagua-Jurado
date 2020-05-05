package com.politecnicomalaga.Selector;

import com.politecnicomalaga.Modelo.LoteProductos;
import com.politecnicomalaga.Modelo.Producto;

public class SelectorPrecio implements SelectorMejorProducto{
    @Override
    public Producto elegirMejorProducto(LoteProductos loteProductos) {
        Producto productoMasBArato= new Producto(Integer.MIN_VALUE, 0);
        for (Producto producto: loteProductos.getProductos())
            if (producto.getPrecio()> productoMasBArato.getPrecio())
                productoMasBArato=producto;
            return productoMasBArato;
    }
}
