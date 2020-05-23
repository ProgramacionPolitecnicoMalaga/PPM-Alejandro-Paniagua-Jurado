package com.politecnicomalaga.vista;
import com.politecnicomalaga.modelo.Validacion;
import javax.swing.*;
import java.awt.*;

public class ValidacionRender implements ListCellRenderer<Validacion> {
    private JPanel panelMain;
    private JLabel lblAlgoritmo;
    private JLabel lblHash;
    private JLabel lblValidacion;
    private JLabel lblNombre;
    private JLabel lblContraseña;
    private ImageIcon validacionImg;
    private Image validacionImagen;

    @Override
    public Component getListCellRendererComponent(JList<? extends Validacion> list, Validacion validacion, int index, boolean isSelected, boolean cellHasFocus) {
        lblNombre.setText(validacion.getUsuario().getNombre());
        lblContraseña.setText(validacion.getContraseña());
        lblHash.setText(validacion.getUsuario().getHash());
        lblAlgoritmo.setText(validacion.getUsuario().getAlgoritmo());

        if (validacion.isCorrecto()) {
            validacionImg = new ImageIcon("src/main/resources/ok.png");
        }
        else {
            validacionImg = new ImageIcon("src/main/resources/error.png");
        }
        validacionImagen=validacionImg.getImage();
        lblValidacion.setIcon(new ImageIcon(validacionImagen));
        return panelMain;
    }
}
