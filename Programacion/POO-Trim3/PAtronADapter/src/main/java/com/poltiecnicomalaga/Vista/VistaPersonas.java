package com.poltiecnicomalaga.Vista;

import com.poltiecnicomalaga.Adapter.Adaptador;
import com.poltiecnicomalaga.Modelo.Persona;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class VistaPersonas {
    private JPanel panelMain;
    private JButton borrarButton;
    private JButton PrintButton;
    private JButton insertarButton;
    private JTable tblPersonas;

    private ArrayList<Persona> personas;

    public JPanel getPanelMain(){
        return panelMain;
    }

    public VistaPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
        Adaptador adaptador = new Adaptador(personas);
        tblPersonas.setModel(adaptador);



        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (tblPersonas.getSelectedRow()!=-1){
                    adaptador.removeRow(tblPersonas.getSelectedRow());
                }
            }
        });

        PrintButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("---------------------------------");
                System.out.println("El estado actual de la lista es:\n");
                for (Persona persona: personas) System.out.println(persona);
                System.out.println("---------------------------------");
            }
        });

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                adaptador.addRow();
            }
        });
        tblPersonas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_DELETE){
                    tblPersonas.getCellEditor().stopCellEditing();
                    adaptador.removeRow(tblPersonas.getSelectedRow());
                }
            }
        });
    }
}
