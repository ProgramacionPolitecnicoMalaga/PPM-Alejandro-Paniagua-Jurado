package Vista;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;
        Scanner lectorOp = new Scanner(System.in).useDelimiter("\n");
        Interfaz interfazUsuario = new Interfaz();
        while(opcion < 6){
            interfazUsuario.menu(opcion,lectorOp);
        }
    }
}
