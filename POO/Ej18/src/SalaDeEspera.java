import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SalaDeEspera {
    private JPanel panelMain;
    private JTextField textNombre;
    private JTextField textEdad;
    private JComboBox <String> comboTipo;
    private JComboBox <String> comboGravedad;
    private JTextArea textLista;
    private JButton buttonRegistrar;
    private JButton buttonAtender;
    private JTextField textUltimo;
    private String[] tipo= new String[11];
    private int prioridad;
    private ListaDeUrgencias listaDeUrgencias= new ListaDeUrgencias();

    public SalaDeEspera() {
       leerLista();
        buttonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLista.setText("");
                Incidencia incidencia = new Incidencia((String) comboTipo.getSelectedItem(), getGravedad());
                prioridad=obtenerPrioridad(incidencia);
                listaDeUrgencias.añadirPaciente(new Paciente(textNombre.getText(), Integer.parseInt(textEdad.getText()), prioridad, incidencia));
                ordenarListado();
            }
        });
        buttonAtender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    textLista.setText("");
                    textUltimo.setText("");
                    textUltimo.setText("Prioridad: " + listaDeUrgencias.getPrimero().getPrioridad() + ", Paciente: " + listaDeUrgencias.getPrimero().getNombre());
                    listaDeUrgencias.getLista().remove(listaDeUrgencias.getPrimero());
                    ordenarListado();
            }
        });
    }

    public int obtenerPrioridad(Incidencia incidencia) {
        if (comboGravedad.getSelectedItem().equals("Grave")) {
            prioridad = 1;
        } else {
            for (int i = 0; i < tipo.length; i++) {
                if (tipo[i].equals(incidencia.getDescripcion())) {
                    prioridad = i + 1;
                }
            }

        }
        return prioridad;
    }
    public void ordenarListado() {
        Object[] list = listaDeUrgencias.getLista().toArray();
        Arrays.sort(list);
        for (int i = 0; i < list.length; i++) {
            textLista.append(list[i].toString());
        }
    }
    public boolean getGravedad(){
        if (comboGravedad.getSelectedItem().equals("Grave")){
            return true;
        }
        return false;
    }
    public void leerLista(){
        String[] linea;
        BufferedReader br= null;
        int i=0;
        try{
            br = new BufferedReader(new FileReader("tipourgencia.csv"));
            String line=br.readLine();
            while (null!=line){
                linea= line.split("-");
                tipo[i]=linea[1];
                comboTipo.addItem(linea[1]);
                i++;
                line=br.readLine();
            }
            comboGravedad.addItem("Grave");
            comboGravedad.addItem("Leve");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ej18");
        frame.setContentPane(new SalaDeEspera().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(800, 600));
    }
}
