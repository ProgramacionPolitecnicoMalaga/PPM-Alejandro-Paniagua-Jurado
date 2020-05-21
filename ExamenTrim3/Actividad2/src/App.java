import com.politecnicomalaga.Factory.SelectorDeIntentos;
import com.politecnicomalaga.Modelo.ListaDeNiños;
import com.politecnicomalaga.Modelo.Niño;
import com.politecnicomalaga.Strategy.SelectorDeIntentosStrategy;

import java.util.Scanner;

public class App {
    private static Scanner lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    private static ListaDeNiños listaDeNiños;

    public static void main(String[] args) {
        añadirNiños();
        int opcion;
        System.out.println(listaDeNiños);
        do {
            System.out.println("-------------------------------------");
            System.out.println("Elige un intento: ");
            System.out.print("1. intento 1\n" +
                    "2.  intento 2\n" +
                    "3.  intento 3\n" +
                    "0.  intento 4\n");
            opcion = lectorTeclado.nextInt();
            System.out.println("------------------------------------");
            if (opcion!=0) {
                SelectorDeIntentosStrategy selectorDeIntentosStrategy = SelectorDeIntentos.getSelectorDeIntento(opcion);
                loteDeProductos.setSelectorDeMejorProducto(selectorDeMejorProducto);
                System.out.println("\nMejor producto: " + loteDeProductos.getSellersChoice() + "\n===================\n");
            }
        } while (opcion!=0);
    }

    public static void añadirNiños() {
        listaDeNiños = new ListaDeNiños();
        listaDeNiños.addNiño(new Niño("Jacinto", "paquete de galletas"));
    }
}

