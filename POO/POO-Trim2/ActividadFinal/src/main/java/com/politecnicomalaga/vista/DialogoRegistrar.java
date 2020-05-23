package com.politecnicomalaga.vista;

import com.politecnicomalaga.control.GestorUsuarios;

import javax.swing.*;
import java.awt.event.*;

public class DialogoRegistrar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JPasswordField txtContraseña;
    private JComboBox cbAlgoritmo;

    private DataTransfer dataTransfer;

    private void createUIComponents() {
        cbAlgoritmo = new JComboBox();
        cbAlgoritmo.addItem("Algoritmos");
        cbAlgoritmo.addItem(GestorUsuarios.ALGORITMO_BCRYPT);
        cbAlgoritmo.addItem(GestorUsuarios.ALGORITMO_SHA512);
    }

    public DialogoRegistrar(DataTransfer dataTransfer) {
        this.dataTransfer = dataTransfer;
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        if (!txtNombre.getText().equals("") && txtContraseña.getPassword().length!=0) {
            dataTransfer.put("nombre", txtNombre.getText());
            dataTransfer.put("contraseña", new String(txtContraseña.getPassword()));
            dataTransfer.put("algoritmo", getCbAlgoritmo());
            dataTransfer.put("resultado", "correcto");
        } else
            dataTransfer.put("resultado", "cancelado");
        dispose();
    }

    private void onCancel() {
        dataTransfer.put("resultado", "cancelado");
        dispose();
    }

    public String getCbAlgoritmo() {
        int algoritmo = cbAlgoritmo.getSelectedIndex();
        switch (algoritmo) {
            case 1:
                return GestorUsuarios.ALGORITMO_BCRYPT;
            case 2:
                return GestorUsuarios.ALGORITMO_SHA512;
            default:
                return GestorUsuarios.ALGORITMO_BCRYPT;
        }
    }


}
