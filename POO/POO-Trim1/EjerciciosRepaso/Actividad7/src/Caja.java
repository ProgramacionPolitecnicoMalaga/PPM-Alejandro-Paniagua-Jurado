import java.util.Iterator;

public class Caja {
    private double recuento;
    private Cafeteria cafeteria;
    public Caja(){

    }
    public double getRecuento(){
        return recuento+=cafeteria.getRecuentoCaja();
    }
    public double cobrarMesa(Mesa mesa){
        double total= getTotalMesa(mesa);
        recuento+=total;
        return total;
    }
    public double getTotalMesa(Mesa mesa){
        double total=0;
        Iterator<Producto>iterator=mesa.getProductos().iterator();
        while (iterator.hasNext()){
            total+=iterator.next().getPrecio();
        }
        return total;
    }
}
