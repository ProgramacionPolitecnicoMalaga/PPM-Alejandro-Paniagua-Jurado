package com.politecnicomalaga.Composite;

public interface Servicio {
    double PRECIO_DE_ILINK = 30;
    double PRECIO_DE_RACK = 20;
    double PRECIO_DE_SERVIDOR = 25;
    double PRECIO_DE_CLOUD = 15;
    double PRECIO_DE_VPS = 20;
    int TIPO_PAQUETE = 0;
    int TIPO_PRODUCTO = 1;

    void setPrecio(double precio);
    double getPrecio();
    int getTipo();
}
