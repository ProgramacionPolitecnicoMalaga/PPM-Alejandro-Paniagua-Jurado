package com.poltiecnicomalaga;

import com.poltiecnicomalaga.Modelo.Persona;
import com.poltiecnicomalaga.Vista.VistaPersonas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class App {
   private static ArrayList<Persona> añadirPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        personas.add(new Persona("Pepe", "Villuela", 23));
        personas.add(new Persona("Juan", "García", 45));
        personas.add(new Persona("Pedro", "Rodriguez", 32));
        personas.add(new Persona("Carla", "Prieto", 21));
        return personas;
    }
    public static void main(String[] args) {
        VistaPersonas vistaPersonas=new VistaPersonas(añadirPersonas());
        JFrame frame = new JFrame("Tabla");
        frame.setContentPane(vistaPersonas.getPanelMain());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
