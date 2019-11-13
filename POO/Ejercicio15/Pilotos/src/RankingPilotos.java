import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class RankingPilotos {
    private ArrayList<Piloto> listaPilotos = new ArrayList<>();

    public void TotaldePilotos() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("pilotos.csv"));
            String line = br.readLine();
            while (null != line) {
                String[] fields = line.split(";");
                listaPilotos.add(new Piloto(fields[1], fields[2], Integer.parseInt(fields[0])));
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void adelantarPiloto(Piloto piloto, int posicionSalida, int posicionAdelantada){
        listaPilotos.add(posicionAdelantada, piloto);
        listaPilotos.remove(posicionSalida +1);
    }

    public Piloto getPiloto(int posicion){
        return listaPilotos.get(posicion);
    }
    public void posicionPilotos() {
        Iterator<Piloto> it = listaPilotos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    public void eliminarDescalificados() {
        Predicate<Piloto> condicion = piloto -> piloto.getDescalificado();
        listaPilotos.removeIf(condicion);
    }
}
