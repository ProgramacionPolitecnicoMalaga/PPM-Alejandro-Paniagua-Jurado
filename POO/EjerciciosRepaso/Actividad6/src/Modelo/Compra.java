package Modelo;

public class Compra {
    private Vehiculo vehiculo;
    private Cliente cliente;

    public Compra(Vehiculo vehiculo, Cliente cliente){
        this.vehiculo = vehiculo;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return " Compra {\n" +
                "  vehiculo: " + vehiculo + "\n" +
                "  cliente: " + cliente + "\n" +
                '}';
    }
}
