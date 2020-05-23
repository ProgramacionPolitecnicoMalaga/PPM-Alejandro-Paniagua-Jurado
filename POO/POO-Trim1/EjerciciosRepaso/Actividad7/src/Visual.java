import java.util.Scanner;

public class Visual {
    private Scanner lectorTeclado;

    public Visual() {
        lectorTeclado = new Scanner(System.in).useDelimiter("\n");
    }

    public int mostrarMenu() {
        System.out.println("\nOpciones:\n" +
                "1. Introducir un nuevo producto.\n" +
                "2. Añadir producto a mesa.\n" +
                "3. Cerrar mesa.\n" +
                "4. Listado de mesas abiertas.\n" +
                "5. Listado de mesas cerradas.\n" +
                "6. Recuento de caja.\n" +
                "0. Salir.\n" +
                "Opción: ");
        return lectorTeclado.nextInt();
    }

    public String obtenerProducto() {
        System.out.println("Introduce el nombre del producto: ");
        return lectorTeclado.next();
    }

    public double obtenerPrecio() {
        System.out.println("Introduce el precio del producto: ");
        return lectorTeclado.nextDouble();
    }

    public int obtenerNumeroMesa() {
        System.out.println("Introduce el número de mesa: ");
        return lectorTeclado.nextInt();
    }
}
