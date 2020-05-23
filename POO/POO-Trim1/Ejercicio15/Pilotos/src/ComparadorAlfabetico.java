import java.util.Comparator;

public class ComparadorAlfabetico implements Comparator<Piloto> {
    @Override
    public int compare(Piloto o1, Piloto o2) {
        return o1.getNombre().compareToIgnoreCase(o2.getNombre());
    }
}
