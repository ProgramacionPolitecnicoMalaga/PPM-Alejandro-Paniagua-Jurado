package L.Negocio;
import Modelo.Cliente;
import Modelo.Compra;
import Modelo.Vehiculo;
import Modelo.Venta;

import java.util.ArrayList;
import java.util.Scanner;

public class Concesionario {
    private double precio;
    private double precioVenta;
    private double precioCompra;
    private Scanner lector = new Scanner(System.in).useDelimiter("\n");
    ArrayList<Cliente> listaClientes=new ArrayList<>();
    ArrayList<Vehiculo>listaVehiculos=new ArrayList<>();

    public double getPrecioCompra() {
        return precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void addCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public void addVehiculo(Vehiculo vehiculo){
        listaVehiculos.add(vehiculo);
    }
}