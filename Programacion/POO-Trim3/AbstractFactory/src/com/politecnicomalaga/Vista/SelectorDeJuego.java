package com.politecnicomalaga.Vista;

import com.politecnicomalaga.Factory.Desierto;
import com.politecnicomalaga.Factory.Espacio;
import com.politecnicomalaga.Factory.Personaje;
import com.politecnicomalaga.Factory.Selva;

import java.util.Scanner;

public class SelectorDeJuego {
    private Scanner lectorTeclado;

    private final static int SELVA = 1;
    private final static int DESIERTO = 2;
    private final static int ESPACIO = 3;

    public SelectorDeJuego() {
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarOpciones() {
        System.out.println("\nPor favor, elija un escenario:\n" +
                "1. Selva.\n" +
                "2. Desierto.\n" +
                "3. Espacio.\n" +
                "Opción: ");
        return lectorTeclado.nextInt();
    }

    public Personaje inicializarEscenario() {
        Personaje personajeFactory = null;
        int opcion = mostrarOpciones();
        switch (opcion) {
            case SELVA:
                personajeFactory = new Selva();
                break;
            case DESIERTO:
                personajeFactory = new Desierto();
                break;
            case ESPACIO:
                personajeFactory = new Espacio();
                break;
        }
        return personajeFactory;
    }
}
