package com.politecnicomalaga.presentacion;

import com.politecnicomalaga.modelo.Circulo;
import com.politecnicomalaga.modelo.Cuadrado;
import com.politecnicomalaga.modelo.Figura;
import com.politecnicomalaga.modelo.Triangulo;
import com.politecnicomalaga.negocio.CalculadoraArea;

import javax.sql.rowset.CachedRowSet;
import java.lang.reflect.Array;

public class Figuras {
    static Figura[] figuras;

    public static void main(String[] args) {
        figuras=new Figura[3];

        Figura circulo = new Circulo("red");
        ((Circulo)circulo).setRadio(5);

        Figura triangulo = new Triangulo("green");
        ((Triangulo)triangulo).setAltura(2);
        ((Triangulo)triangulo).setBase(3);


        Figura cuadrado = new Cuadrado("blue");
        ((Cuadrado)cuadrado).setLado(5);

        figuras[0]=circulo;
        figuras[1]=triangulo;
        figuras[2]=cuadrado;
        CalculadoraArea calculadora=new CalculadoraArea();
        for (int i=0; i<figuras.length; i++)
            System.out.println(calculadora.calcular(figuras[i]));
    }
}
