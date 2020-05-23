package com.politecnicomalaga.vista;

import javax.swing.*;
import java.awt.event.*;

public class DialogoValidar extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtNombre;
    private JPasswordField txtContraseña;

    private DataTransfer dataTransfer;

    public DialogoValidar(DataTransfer dataTransfer) {
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
            dataTransfer.put("resultado", "correcto");
        }
        else dataTransfer.put("resultado", "incorrecto");
        dispose();
    }

    private void onCancel() {
        dataTransfer.put("resultado", "cancelado");
        dispose();
    }
}
