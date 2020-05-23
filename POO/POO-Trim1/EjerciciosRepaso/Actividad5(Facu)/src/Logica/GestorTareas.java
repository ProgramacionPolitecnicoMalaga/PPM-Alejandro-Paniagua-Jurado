package Logica;

import Modelo.Categoria;
import Modelo.ListaCategorias;
import Modelo.Tarea;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class GestorTareas {
    private ListaCategorias categorias;
    public final static int TAREAS_EN_FECHA = 1;
    public final static int TAREAS_EN_TIEMPO = 2;
    public final static int TAREAS_RETRASADAS = 3;

    public GestorTareas(ListaCategorias categorias) {
        this.categorias = categorias;
    }

    public void añadirNuevaTarea(Tarea tarea, Categoria categoria) {
        categoria.getTareasPendientes().add(tarea);
    }

    public void eliminarTareaPendiente(Tarea tarea) {
        Categoria categoria = tarea.getCategoria();
        categoria.getTareasPendientes().remove(tarea);
        categoria.getTareasCompletadas().add(tarea);
    }

    public void listaTareasPendientes() {
        Iterator<Categoria> it = categorias.getCategorias().iterator();
        while (it.hasNext()) {
            Categoria categoria = it.next();
            System.out.println("Lista de tareas pendientes de la categoría: " + categoria.getNombre());
            listaTareasPorCategoria(categoria.getTareasPendientes());
        }
    }

    public void listaTareasPorCategoria(List list) {
        Iterator<Tarea> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
            System.out.println("======================");
        }
    }

    public void listaTareasPorFecha(String fecha, int condicion) {
        Iterator<Categoria> it = categorias.getCategorias().iterator();
        while (it.hasNext()) {
            Categoria categoria = it.next();
            Iterator<Tarea> it2 = categoria.getTareasPendientes().iterator();
            while (it2.hasNext()) {
                Tarea tarea = it2.next();
                consultasPorFecha(tarea, fecha, condicion);
            }
        }
    }

    public void consultasPorFecha(Tarea tarea, String fecha, int condicion) {
        Calendar fechaConsultada = new Fecha(fecha).getFecha();
        switch (condicion) {
            case TAREAS_EN_FECHA:
                if (tarea.getFechaLimite().diasEntreDosFechas(fechaConsultada) == 0) {
                    System.out.println(tarea);
                }
                break;
            case TAREAS_EN_TIEMPO:
                if (tarea.getFechaLimite().diasEntreDosFechas(fechaConsultada) >= 0) {
                    System.out.println(tarea);
                }
                break;
            case TAREAS_RETRASADAS:
                if (tarea.getFechaLimite().diasEntreDosFechas(fechaConsultada) < 0) {
                    System.out.println(tarea);
                }
                break;
        }
    }
}
