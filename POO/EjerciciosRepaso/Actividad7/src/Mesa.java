import java.util.ArrayList;

public class Mesa {
    private int numeroMesa;
    private boolean cerrada;

    private ArrayList<Producto> productos;

    public Mesa(int numero) {
        this.numeroMesa = numero;
        cerrada = true;
        productos = new ArrayList<>();
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
        cerrada = false;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public boolean isCerrada() {
        return cerrada;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    @Override
    public String toString() {
        return "Mesa{" +
                "numeroMesa=" + numeroMesa +
                ", cerrada=" + cerrada +
                ", productos=" + productos +
                '}';
    }

    public void setCerrada(boolean cerrada) {
        this.cerrada = cerrada;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}