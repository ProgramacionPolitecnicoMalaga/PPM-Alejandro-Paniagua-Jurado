package com.politecnicomalaga.Paneles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal {
    private JPanel panelContenedor;
    private JMenu menuMostrarPanel;
    private JMenuItem menuItemPanel1;
    private JMenuItem menuItemPanel2;
    private JPanel panelPrincipal;
    private JPanel panelIntercambio;

    public PanelPrincipal(){
        Panel1 panel1=new Panel1();
        Panel2 panel2=new Panel2();

        panelIntercambio.add(panel1.getPanel(), "panel1");
        panelIntercambio.add(panel2.getPanel(), "panel2");

        menuItemPanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("panel 1");
                CardLayout layout= (CardLayout) panelIntercambio.getLayout();
                layout.show(panelIntercambio, "panel1");
            }
        });

        menuItemPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("panel 2");
                CardLayout layout= (CardLayout) panelIntercambio.getLayout();
                layout.show(panelIntercambio, "panel2");
            }
        });
    }

    public JPanel getPanel() {
        return panelPrincipal;
    }
}
