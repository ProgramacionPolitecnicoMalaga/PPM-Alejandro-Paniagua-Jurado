package Modelo;

public class Venta {
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Venta(Vehiculo vehiculo, Cliente cliente){
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return " Venta {\n" +
                "  vehiculo: " + vehiculo + "\n" +
                "  cliente: " + cliente + "\n" +
                '}';
    }
}
