import java.util.ArrayList;

public class Cuenta {
    private int numeroMesa;
    private int cuentaSiguiente=1;
    private int numeroCuenta=0;
    private double total;
    private ArrayList<Producto> listaproductos= new ArrayList<>();

    public Cuenta(int numeroMesa, ArrayList<Producto> listaproductos, double total){
        this.numeroMesa = numeroMesa;
       this.listaproductos=listaproductos;
        this.total = total;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "numeroMesa=" + numeroMesa +
                ", numeroCuenta=" + numeroCuenta +
                ", total=" + total +
                ", listaproductos=" + listaproductos +
                '}';
    }
}
