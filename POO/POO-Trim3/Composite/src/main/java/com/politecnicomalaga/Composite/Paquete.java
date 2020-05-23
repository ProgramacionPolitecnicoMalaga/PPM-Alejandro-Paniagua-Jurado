package com.politecnicomalaga.Composite;

import java.util.ArrayList;

public class Paquete implements Servicio {
    private String nombre;
    private double tasa;
    private ArrayList<Servicio> listaServicios;

    public Paquete(String nombre, double tasa) {
        this.nombre = nombre;
        this.tasa = tasa;
        listaServicios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void setPrecio(double precio) {
        tasa = precio;
    }

    @Override
    public double getPrecio() {
        double total = tasa;
        for (Servicio servicio: listaServicios) {
            total += servicio.getPrecio();
        }
        return total;
    }

    @Override
    public int getTipo() {
        return 0;
    }
    public void addServicio(Servicio servicio) {
        listaServicios.add(servicio);
    }

    public void removeServicio(Servicio servicio) {
        listaServicios.remove(servicio);
    }
    public Servicio getServicioPorNombre(String nombre) {
        if (this.nombre.equals(nombre))
            return this;
        for (Servicio servicio : listaServicios) {
            if (servicio.getTipo() == Servicio.TIPO_PAQUETE){
                Servicio paquete = ((Paquete) servicio).getServicioPorNombre(nombre);
                if (paquete!=null && ((Paquete) paquete).getNombre().equals(nombre))
                    return paquete;
            } else if (((Producto) servicio).getNombre().equals(nombre))
                return servicio;
        }
        return null;
    }

    @Override
    public String toString() {
        String resultado = nombre + " [";
        for (int i=0; i<listaServicios.size()-1; i++) {
            resultado += listaServicios.get(i).toString() + ",";
        }
        if (listaServicios.size()>0)
            resultado += listaServicios.get(listaServicios.size()-1);
        resultado += "]";
        return resultado;
    }
}
