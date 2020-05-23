package com.politecnicomalaga.negocio;

import com.politecnicomalaga.modelo.Circulo;
import com.politecnicomalaga.modelo.Cuadrado;
import com.politecnicomalaga.modelo.Figura;
import com.politecnicomalaga.modelo.Triangulo;

public class CalculadoraArea {
    public double calcular(Figura figura) {
        double area =0;
        if (figura instanceof Circulo){
            Circulo circulo = (Circulo)figura;
            area=Math.pow(circulo.getRadio(), 2)*Math.PI;
        }else if (figura instanceof Triangulo){
            Triangulo triangulo=(Triangulo) figura;
            area = triangulo.getBase()*triangulo.getAltura()/2;
        }else if (figura instanceof Cuadrado){
            Cuadrado cuadrado=(Cuadrado) figura;
            area= Math.pow(cuadrado.getLado(), 2);
        }
        return area;
    }
}
