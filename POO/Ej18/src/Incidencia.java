public class Incidencia {
    private String descripcion;
    private boolean grave;
    public Incidencia(String descripcion, boolean grave){
        this.descripcion=descripcion;
        this.grave=grave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getGravedad() {
        if (grave) {
            return "Grave";
        }
        return "Leve";
    }

    @Override
    public String toString() {
        return
                ", descripcion='" + descripcion + '\'' +
                ", gravedad=" + grave +
                '}';
    }
}
