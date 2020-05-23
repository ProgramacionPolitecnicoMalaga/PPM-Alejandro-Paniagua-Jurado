package com.politecnicomalaga.vista;

import com.politecnicomalaga.modelo.Validacion;

import javax.swing.*;
import java.awt.*;

public class DatosUsuario implements ListCellRenderer<Validacion> {
    private JLabel lblNombre;
    private JLabel lblAlgoritmo;
    private JLabel lblHash;
    private JLabel lblCorrecto;
    private JLabel lblContraseña;
    private JPanel pnlDatos;


    @Override
    public Component getListCellRendererComponent(JList<? extends Validacion> list, Validacion validacion, int index, boolean isSelected, boolean cellHasFocus) {
        lblNombre.setText(validacion.getUsuario().getNombre());
        lblContraseña.setText(validacion.getContraseña());
        lblHash.setText(validacion.getUsuario().getHash());
        lblAlgoritmo.setText(validacion.getUsuario().getAlgoritmo());

        if (validacion.isCorrecto()) {
            lblCorrecto.setText("correcto");
        }
        else {
            lblCorrecto.setText("incorrecto");
        }
        return pnlDatos;
    }
}
