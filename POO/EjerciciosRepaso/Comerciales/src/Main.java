import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int Isabel[] = {7, 7, 10, 6, 4};
        int Vicente[] = {4, 7, 5, 4, 5};
        int opcion = 0;
        int item = 0;
        String nombreComercial;

        Scanner lectorteclado = new Scanner(System.in);
        System.out.println("Elige una opción");
        System.out.println("1. Empleados que vendieron un número de items");
        System.out.println("2. Obtener el promedio de ventas de cada uno");
        System.out.println("3. Averiguar quién han conseguido el mayor número de ventas en un día");
        System.out.println("4. Insertar un nuevo empleado y sus ventas");

        opcion = lectorteclado.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("¿Que numero de items quieres buscar?");
                item = lectorteclado.nextInt();
                for (int i = 0; i < Isabel.length; i++) {
                    if (item == Isabel[i]) {
                        System.out.println("Isabel");
                    }
                }
                for (int j = 0; j < Vicente.length; j++) {
                    if (item == Vicente[j]) {
                        System.out.println("Vicente");
                    }
                }
                break;
            case 2:
                double ventasTotales = 0.0;
                for (int i = 0; i < Isabel.length; i++)
                    ventasTotales += Isabel[i];
                System.out.println("Promedio de ventas de Isabel " + ventasTotales / 5);
                double ventasTotales2 = 0.0;
                for (int j = 0; j < Vicente.length; j++)
                    ventasTotales2 += Vicente[j];
                System.out.println("Promedio de ventas de Vicente " + ventasTotales2 / 5);
                break;
            case 3:
                int ventaMaxima = 0;
                int ventaMaxima2=0;
                for (int i = 0; i < Isabel.length; i++) {
                    if (Isabel[i]>ventaMaxima){
                        ventaMaxima=Isabel[i];
                    }
                }
                for (int j=0; j<Vicente.length;j++){
                    if (Vicente[j]>ventaMaxima2){
                        ventaMaxima2=Vicente[j];
                    }
                }
                if (ventaMaxima>ventaMaxima2){
                    System.out.println("Isabel es el que ha vendido mas items con un total de: " + ventaMaxima);
                }else System.out.println("Vicente es el que ha vendido mas items con un total de: " + ventaMaxima2);
                break;
            case 4:
                System.out.println("Nombre del Comercial");
                String nombre=lectorteclado.next();
                Comercial nuevoComercial=new Comercial(nombre);
                System.out.println("venta 1: ");
                int venta1 = lectorteclado.nextInt();
                System.out.println("venta 2: ");
                int venta2 = lectorteclado.nextInt();
                System.out.println("venta 3: ");
                int venta3 = lectorteclado.nextInt();
                System.out.println("venta 4: ");
                int venta4 = lectorteclado.nextInt();
                System.out.println("venta 5: ");
                int venta5 = lectorteclado.nextInt();
                nuevoComercial.addVentas(venta1, venta2, venta3, venta4, venta5);
                System.out.println("se ha registrado a: "+ nuevoComercial.toString());


                }
        }
    }

