import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MapaAeropuerto {
    private JPanel panelMain;
    private JComboBox cBoxLista;
    private JButton btonBuscar;
    private JLabel lblPais;
    private JMapViewer mapa;
    private NodeList nodo;
    public MapaAeropuerto() {
        btonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pais = cBoxLista.getSelectedItem().toString();
                mapa.removeAllMapMarkers();
                for (int i=0; i< nodo.getLength(); i++){
                    if (pais.compareToIgnoreCase(nodo.item(i).getAttributes().getNamedItem("pais").getNodeValue())==0) {
                        double latitud = Double.parseDouble(nodo.item(i).getAttributes().getNamedItem("lat").getNodeValue());
                        double longitud = Double.parseDouble(nodo.item(i).getAttributes().getNamedItem("lon").getNodeValue());
                        mapa.addMapMarker(new MapMarkerDot(longitud, latitud));
                        mapa.setDisplayToFitMapMarkers();
                    }
                }
            }
        });
    }
    public static NodeList leerXML(String archivo){
        try {
            String dir = System.getProperty("user.dir");
            File archEnt = new File(dir + File.separator + archivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(archEnt);
            doc.getDocumentElement().normalize();
            NodeList nodo = doc.getElementsByTagName("aeropuerto");
            return nodo;
        } catch (ParserConfigurationException e) {
            return null;
        } catch (SAXException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    }
    private void createUIComponents() {
        cBoxLista = new JComboBox();
        nodo = leerXML("aeropuertos.xml");
        ArrayList<String> Paises = new ArrayList<>();
        String pais;
        for (int i = 0; i < nodo.getLength(); i++) {
            pais = nodo.item(i).getAttributes().getNamedItem("pais").getNodeValue();
            Paises.add(i, pais);
        }
        Collections.sort(Paises);
        Iterator<String> it = Paises.iterator();
        String paisActual = "";
        while (it.hasNext()) {
            pais = it.next();
            if (paisActual.compareTo(pais) != 0) {
                cBoxLista.addItem(pais);
                paisActual = pais;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MapaAeropuerto");
        frame.setContentPane(new MapaAeropuerto().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
