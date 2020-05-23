import java.sql.ClientInfoStatus;
import java.util.Comparator;

public class Paciente  {
    private String nombre;
    private int edad;
    private int prioridad;
    private Incidencia incidencia;
    public Paciente(String nombre, int edad, int prioridad, Incidencia incidencia ){
        this.nombre=nombre;
        this.edad=edad;
        this.incidencia=incidencia;
        this.prioridad=prioridad;

    }
    public static final Comparator<Paciente> COMPARADOR_PRIORIDAD= new Comparator<Paciente>() {
        @Override
        public int compare(Paciente paciente, Paciente p1) {
            return paciente.getPrioridad() - p1.getPrioridad();
        }
    };

    public String getNombre() {
        return nombre;
    }



    public int getPrioridad() {
        return prioridad;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", prioridad=" + prioridad +
                ", incidencia=" + incidencia +
                '}';
    }
    public int compareTo(Paciente o) {
        if (prioridad < o.getPrioridad()) {
            return -1;
        }
        if (o.getPrioridad() < prioridad) {
            return 1;
        }
        return 0;
    }
}
