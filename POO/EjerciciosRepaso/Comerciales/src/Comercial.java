public class Comercial {
    String nombre;
    int[]ventas;
    public Comercial(String nombre){
        this.nombre = nombre;
        ventas = new int[5];
    }

    public void addVentas(int venta1, int venta2, int venta3, int venta4, int venta5){
        ventas = new int[]{venta1, venta2, venta3, venta4, venta5};
    }

    public int[] getVentas(){
        return ventas;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
