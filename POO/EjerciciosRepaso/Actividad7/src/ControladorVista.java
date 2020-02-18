public class ControladorVista {
    private Visual vista;
    public Cafeteria cafeteria = new Cafeteria();;

    private final static int INTRODUCIR_PRODUCTO = 1;
    private final static int AÑADIR_PRODUCTO_MESA = 2;
    private final static int CERRAR_MESA = 3;
    private final static int CONSULTA_MESAS_ABIERTAS = 4;
    private final static int CONSULTA_MESAS_CERRADAS = 5;
    private final static int RECUENTO_CAJA = 6;
    private final static int TERMINAR = 0;

    public void inicializarVista() {
        vista = new Visual();
        int opcion;
        opcion = vista.mostrarMenu();
        while (opcion != TERMINAR) {
            switch (opcion) {
                case INTRODUCIR_PRODUCTO:
                    String nombreProducto = vista.obtenerProducto();
                    double precioProducto = vista.obtenerPrecio();
                    cafeteria.addProducto(nombreProducto,precioProducto);
                    break;
                case AÑADIR_PRODUCTO_MESA:
                    int numeroMesa = vista.obtenerNumeroMesa();
                    String nombreProductoAMesa = vista.obtenerProducto();
                    cafeteria.addProductoByMesa(numeroMesa, nombreProductoAMesa);
                    break;
                case CERRAR_MESA:
                    int numeroMesaACerrar = vista.obtenerNumeroMesa();
                    Cuenta cuenta = cafeteria.cerrarMesa(numeroMesaACerrar);
                    System.out.println(cuenta);
                    break;
                case CONSULTA_MESAS_ABIERTAS:
                    System.out.println(cafeteria.getMesasAbiertas());
                    break;
                case CONSULTA_MESAS_CERRADAS:
                    System.out.println(cafeteria.getMesasCerradas());
                    break;
                case RECUENTO_CAJA:
                    System.out.println(cafeteria.getRecuentoCaja() + "€");
                    break;
            }
            opcion = vista.mostrarMenu();
        }
    }
}
