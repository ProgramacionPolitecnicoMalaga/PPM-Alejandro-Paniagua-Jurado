package com.politecnicomalaga;

import com.politecnicomalaga.Builder.Builder;
import com.politecnicomalaga.Composite.Paquete;
import com.politecnicomalaga.Composite.Servicio;

public class App {
    public static void main(String[] args) {
        Paquete paquete = new Paquete("iLink1", Servicio.PRECIO_DE_ILINK);
        Builder builder = new Builder(paquete);
        builder.initPaquete("iLink1.1", Servicio.PRECIO_DE_ILINK)
                .initPaquete("Rack1", Servicio.PRECIO_DE_RACK)
                .addProducto("Servidor1", Servicio.PRECIO_DE_SERVIDOR)
                .addProducto("Servidor2", Servicio.PRECIO_DE_SERVIDOR)
                .getPadre()
                .initPaquete("Rack2", Servicio.PRECIO_DE_RACK)
                .addProducto("Servidor3", Servicio.PRECIO_DE_SERVIDOR)
                .getPadre()
                .getPadre()
                .initPaquete("Cloud1", Servicio.PRECIO_DE_CLOUD)
                .addProducto("VPS1", Servicio.PRECIO_DE_VPS)
                .initPaquete("Rack3", Servicio.PRECIO_DE_RACK)
                .addProducto("VPS2", Servicio.PRECIO_DE_VPS)
                .addProducto("VPS3", Servicio.PRECIO_DE_VPS);

        Servicio servicio = builder.getResultado();
        System.out.println("Paquete iLink1 construido:");
        System.out.println(servicio.toString() + "\n");

        Servicio paqueteRack1 = ((Paquete) servicio).getServicioPorNombre("Rack1");
        System.out.println("El precio del paquete Rack1 es de " + paqueteRack1.getPrecio() + "€" + "\n");

        Servicio paqueteiLink11 = ((Paquete) servicio).getServicioPorNombre("iLink1.1");
        System.out.println("El precio del paquete iLink1.1 es de " + paqueteiLink11.getPrecio() + "€" + "\n");

        System.out.println("El precio del paquete iLink1 es de " + servicio.getPrecio() + "€" + "\n");

        Servicio paqueteCloud1 = ((Paquete) servicio).getServicioPorNombre("Cloud1");
        System.out.println("El precio del paquete Cloud1 es de " + paqueteCloud1.getPrecio() + "€");
    }
}
