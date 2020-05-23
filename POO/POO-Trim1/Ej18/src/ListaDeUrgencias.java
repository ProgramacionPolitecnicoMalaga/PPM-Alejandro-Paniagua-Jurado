import java.util.PriorityQueue;

public class ListaDeUrgencias {
    PriorityQueue<Paciente> listaEspera = new PriorityQueue<Paciente>(Paciente.COMPARADOR_PRIORIDAD);
    public ListaDeUrgencias() {

    }

    public PriorityQueue getLista(){
        return listaEspera;
    }
    public Paciente getPrimero() {
        return listaEspera.peek();
    }
    public void añadirPaciente(Paciente paciente) {
        listaEspera.add(paciente);
    }
}

