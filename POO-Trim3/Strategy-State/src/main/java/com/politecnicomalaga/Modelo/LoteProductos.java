package com.politecnicomalaga.Modelo;

import java.util.ArrayList;

public class LoteProductos {
    private ArrayList<Producto> productos;

    public LoteProductos(){
        productos=new ArrayList<>();
    }
    public int getTotalProductos(){
        return productos.size();
    }

    public Producto getPosicion(int posicion){
        return productos.get(posicion);
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public ArrayList<Producto> getProductos(){
        return productos;
    }
}
