package Vista;

import L.Negocio.Concesionario;
import Modelo.Cliente;
import Modelo.Vehiculo;

import java.util.Scanner;

public class Interfaz {
    Concesionario concesionario=new Concesionario();
    Scanner lectorTeclado=new Scanner(System.in);
    double precioCompra;
    double precioVenta;

    public void menu(int opcion, Scanner lectorOp){
        System.out.println(" 1. Insertar un vehiculo.\n" +
                " 2. Insertar un cliente.\n" +
                " 3. Realizar compra de un Vehiculo.\n" +
                " 4. Realizar venta de un Vehiculo.\n" +
                " 5. Ver saldo total de un cliente en el concesionario.\n"+
                " 6. Salir.");
        opcion = lectorOp.nextInt();
        evaluadorDeOpciones(opcion);
    }
    public void evaluadorDeOpciones(int opcion){
        switch (opcion){
            case 1:
                pedirDatosVehiculo();
                break;
            case 2:
                pedirDatosCliente();
                break;
            case 3:
                compraVehiculo();
                break;
            case 4:
               ventaVehiculo();
                break;
            case 5:
                saldoDeCliente();
                break;
            case 6:
                System.exit(1);
                break;
            default:
                break;
        }
    }

    private void saldoDeCliente() {
        double saldo;
        saldo = precioCompra - precioVenta;
        System.out.println(" El saldo del cliente "+ "\n es de :   "+saldo+" \n");
    }

    private void pedirDatosCliente() {
        String nombre;
        String apellidos;
        String NIF;
        String cuentaBancaria;
        System.out.println("Nombre");
        nombre=lectorTeclado.next();
        System.out.println("apellidos");
        apellidos=lectorTeclado.next();
        System.out.println("NIF");
        NIF=lectorTeclado.next();
        System.out.println("cuenta bancaria");
        cuentaBancaria=lectorTeclado.next();
        concesionario.addCliente(new Cliente(nombre, apellidos,NIF, cuentaBancaria));
    }

    private void pedirDatosVehiculo() {
        String color;
        String modelo;
        String marca;
        String combustion;
        String estado;
        String fechaFabricacion;
        System.out.println("Color");
        color=lectorTeclado.next();
        System.out.println("Modelo");
        modelo=lectorTeclado.next();
        System.out.println("Marca");
        marca=lectorTeclado.next();
        System.out.println("Combustion");
        combustion=lectorTeclado.next();
        System.out.println("Fecha");
        fechaFabricacion=lectorTeclado.next();
        System.out.println("Estado");
        estado=lectorTeclado.next();
        concesionario.addVehiculo(new Vehiculo(color, modelo,marca, combustion, fechaFabricacion, estado));
    }
    private void compraVehiculo() {
        pedirDatosCliente();
        pedirDatosVehiculo();
        System.out.println("Precio por el que será comprado");
        precioCompra=lectorTeclado.nextDouble();
    }
    private void ventaVehiculo(){
        pedirDatosCliente();
        pedirDatosVehiculo();
        System.out.println("Precio por el que será vendido");
        precioVenta=lectorTeclado.nextDouble();
    }
}
