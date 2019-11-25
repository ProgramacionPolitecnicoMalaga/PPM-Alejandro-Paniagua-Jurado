import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Jugador {
    private String color;
    private String nombreJugador;
    private int casillaActual;
    private int MovimientosTotales=0;
    LinkedList historialDeMovmientos;
    LinkedList redoUndo=new LinkedList();

    public Jugador(String color, String nombreJugador, int casillaActual){
        this.casillaActual=casillaActual;
        this.color=color;
        this.nombreJugador=nombreJugador;
        historialDeMovmientos=new LinkedList();
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }
    public void avanzarCasillas(int casillaAvanzar){
        casillaActual=casillaActual+casillaAvanzar;
        Movimiento avanzar= new Movimiento("Avanza", casillaActual);
        historialDeMovmientos.addLast(avanzar);
    }
    public void retrocederCasillas(int casillaRetroceder){
        casillaActual=casillaRetroceder;
        Movimiento retroceder=new Movimiento("retroceder", casillaActual);
        historialDeMovmientos.addLast(retroceder);
    }
    public void LeerHistorial(){
        ListIterator<Movimiento> it=historialDeMovmientos.listIterator();
        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    public void undo(){
        if (historialDeMovmientos.size()> 0){
            Movimiento undo=(Movimiento)(historialDeMovmientos.getLast());
            historialDeMovmientos.removeLast();
            redoUndo.add(undo);
        }else {
            System.out.println("Estas en la casilla de salida");
        }
    }
    public void redo(){
        if (historialDeMovmientos.size()> 0){
            Movimiento redo=(Movimiento)(redoUndo.getLast());
            historialDeMovmientos.addLast(redo);
            redoUndo.removeLast();
            casillaActual=redo.getNuevaCasilla();
        }else {
            System.out.println("No teienes mas movimientos pra poder deshacer");
        }
    }
}
