
public class Main {

    private static ControladorVista vista;

    public static void main(String[] args) {
        vista = new ControladorVista();
        init();
        vista.inicializarVista();
    }

    public static void init(){
        for (int i=1; i<17; i++) {
            vista.cafeteria.addMesa(i);
        }
        // precios double deben ir con ","
        String[] nombresProducto = {"Caña","Pinta","Carajillo","Mixto","Catalana","Colacao"};
        double[] preciosProducto = {1.00,3.00,1.20,1.50,1.20,1.50};
        for (int i=0; i<nombresProducto.length; i++)
            vista.cafeteria.addProducto(nombresProducto[i],preciosProducto[i]);
    }

}