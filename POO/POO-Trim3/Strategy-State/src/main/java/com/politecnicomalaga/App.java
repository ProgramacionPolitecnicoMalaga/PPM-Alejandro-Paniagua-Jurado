package com.politecnicomalaga;

import com.politecnicomalaga.Modelo.LoteProductos;
import com.politecnicomalaga.Modelo.Producto;
import com.politecnicomalaga.Selector.FactorySelector;
import com.politecnicomalaga.Selector.Selector;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        LoteProductos loteProductos = new LoteProductos();
        loteProductos.addProducto(new Producto(15,1));
        loteProductos.addProducto(new Producto(4,6));
        loteProductos.addProducto(new Producto(32,2));
        loteProductos.addProducto(new Producto(100,1));

        System.out.println("\n ¿ Que producto desea obtener ?");
        System.out.println("-------------------------------------");
        System.out.print( "1. Precio\n" +
                "2. Valoracion\n" +
                "3. Relacion Valoracion-Precio\n" +
                "Opción:");
        int opcion = sc.nextInt();
        System.out.println("------------------------------------");

        Selector selector = new Selector();
        selector.setFiltro(FactorySelector.getFiltro(opcion));

        System.out.println(selector.getProducto(loteProductos));

    }
}
