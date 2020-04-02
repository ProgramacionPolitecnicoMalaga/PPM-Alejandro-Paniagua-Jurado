package com.politecnicomalaga;

public class Calculadora2 {
    public static void main(String[] args) {
        Suma suma = new Suma();
        Resta resta = new Resta();
        Multipliciacion multiplicacion = new Multipliciacion();
        Divison division = new Divison();

        System.out.println(suma.sumar());
        System.out.println(resta.restar());
        System.out.println(multiplicacion.multiplicar());
        System.out.println(division.dividir());
    }
}
