public class Piloto extends ComparadorAlfabetico  implements Comparable<Piloto>{
    String nombre;
    String escudería;
    int posicionDeSalida;
    boolean descalificado=false;

    public Piloto(String nombre, String escudería, int posicionDeSalida){
        this.nombre=nombre;
        this.escudería=escudería;
        this.posicionDeSalida=posicionDeSalida;
    }

    public String getNombre() {

        return nombre;
    }


    public int getPosicionDeSalida() {

        return posicionDeSalida;
    }

    public void setDescalificado() {
        descalificado=true;
    }


    public boolean getDescalificado() {
        return descalificado;
    }

    @Override
    public int compareTo(Piloto o) {
        if(o.getPosicionDeSalida()>posicionDeSalida){
            return -1;
        }else{
            return 1;
        }
    }

    public String toString() {
        return "Pilotos{" +
                "nombre: " + nombre + '\'' +
                ", escuderia: " + escudería + '\'' +
                ", posicionDeSalida: " + posicionDeSalida + "}";
    }
}
