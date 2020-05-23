package com.politecnicomalaga;

import com.politecnicomalaga.control.GestorUsuarios;
import com.politecnicomalaga.vista.Principal;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        Principal vistaPrincipal = new Principal(new GestorUsuarios());
        JFrame frame = new JFrame("Contraseñas");
        frame.setContentPane(vistaPrincipal.getPnlPrincipal());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1200, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
