package com.politecnicomalaga.Vista;

import com.politecnicomalaga.Propierties.ConfigPropierties;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        ConfigPropierties configPropierties = new ConfigPropierties();
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.println("Nombre de la Propiedad :  ");
        String nombre = lectorTeclado.nextLine();
        System.out.println("Valor de la Propiedad :  ");
        String value = lectorTeclado.nextLine();
        configPropierties.setPropertie(nombre,value);
        configPropierties.guardar();
    }
}
