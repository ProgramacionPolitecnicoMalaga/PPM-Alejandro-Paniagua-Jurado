package com.politecnicomalaga.Lanzador;

import com.politecnicomalaga.Paneles.PanelPrincipal;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Paneles");
        frame.setContentPane(new PanelPrincipal().getPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height - 500;
        int width = 500;
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width,200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
