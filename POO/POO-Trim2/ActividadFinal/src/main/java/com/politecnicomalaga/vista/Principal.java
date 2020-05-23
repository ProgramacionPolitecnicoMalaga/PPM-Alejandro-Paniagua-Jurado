package com.politecnicomalaga.vista;


import com.politecnicomalaga.control.GestorUsuarios;
import com.politecnicomalaga.modelo.Usuario;
import com.politecnicomalaga.modelo.Validacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Principal {
    private JButton btnRegistrar;
    private JButton btnValidar;
    private JList listUsuarios;
    private JList listValidacion;
    private JPanel pnlPrincipal;
    private JButton btnBorrar;

    private GestorUsuarios gestorUsuarios;
    private DataTransfer dataTransfer;
    private DefaultListModel<Validacion> modeloDatos;


    private final static int REGISTRO_CORRECTO = 1;
    private final static int REGISTRO_INCORRECTO = 2;
    private final static int REGISTRO_REPETIDO = 3;
    private final static int SELECCIONAR_USUARIO = 4;

    public Principal(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
        actualizarNombres();

        //BOTON REGISTRAR
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataTransfer = new DataTransfer();
                mostarDialogo(new DialogoRegistrar(dataTransfer), e);
                String resultado = (String) dataTransfer.get("resultado");

                if (resultado.equals("correcto")) {
                    if (!gestorUsuarios.usuarioExistente((String) dataTransfer.get("nombre"))) {
                        gestorUsuarios.crearUsuario((String) dataTransfer.get("nombre"), (String) dataTransfer.get("contraseña"), (String) dataTransfer.get("algoritmo"));
                        mostrarMensajeRegistro(REGISTRO_CORRECTO,e);
                        actualizarNombres();
                    }
                    else mostrarMensajeRegistro(REGISTRO_REPETIDO, e);
                }
                else if (resultado.equals("incorrecto")) mostrarMensajeRegistro(REGISTRO_INCORRECTO, e);
            }
        });

        //BOTON VALIDAR
        btnValidar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataTransfer = new DataTransfer();
                mostarDialogo(new DialogoValidar(dataTransfer), e);
                String resultado = (String) dataTransfer.get("resultado");
                if (resultado.equals("correcto")) {
                    if (gestorUsuarios.usuarioExistente((String) dataTransfer.get("nombre"))) {
                        dataTransfer.put("gestorUsuarios", gestorUsuarios);
                        Validacion validacion = ValidacionDatos.comprobarDatos(dataTransfer);
                        modeloDatos.addElement(validacion);
                    }
                    else mostrarMensajeRegistro(REGISTRO_INCORRECTO, e);
                }
                else if (resultado.equals("incorrecto")) mostrarMensajeRegistro(REGISTRO_INCORRECTO, e);
            }
        });

        //BOTON BORRAR
        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listUsuarios.getSelectedValue() != null) {
                    int respuesta = confirmacionBorrado(e);
                    if (respuesta == JOptionPane.OK_OPTION) {
                        ArrayList<String> listaNombres = (ArrayList<String>) listUsuarios.getSelectedValuesList();
                        gestorUsuarios.eliminarUsuario(listaNombres);
                        actualizarNombres();
                    }
                }
                else mostrarMensajeRegistro(SELECCIONAR_USUARIO, e);
            }
        });
    }

    private void createUIComponents() {
        listUsuarios = new JList();
        modeloDatos = new DefaultListModel<>();
        listValidacion.setModel(modeloDatos);
        listValidacion.setCellRenderer(new DatosUsuario());
    }

    public void mostrarMensaje(String mensaje, ActionEvent e) {
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), mensaje);
    }

    public void mostrarMensajeRegistro(int mensaje, ActionEvent e) {
        switch (mensaje) {
            case REGISTRO_CORRECTO:
                mostrarMensaje("Registro realizado correctamente", e);
                break;
            case REGISTRO_INCORRECTO:
                mostrarMensaje("Registro incorrecto, inténtelo de nuevo", e);
                break;
            case REGISTRO_REPETIDO:
                mostrarMensaje("Usuario ya registrado, pruebe con otros datos", e);
                break;
            case SELECCIONAR_USUARIO:
                mostrarMensaje("Selcciones un usuario antes", e);
                break;
        }
    }

    public JPanel getPnlPrincipal() {
        return pnlPrincipal;
    }

    public void actualizarNombres() {
        actualizar(gestorUsuarios.getListaUsuarios());
    }

    public void actualizar(ArrayList<Usuario> listaUsuarios) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Usuario usuario: listaUsuarios) {
            listModel.addElement(usuario.getNombre());
        }
        listUsuarios.setModel(listModel);
    }

    public void mostarDialogo(JDialog dialogo, ActionEvent e) {
        dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) e.getSource()));
        dialogo.pack();
        dialogo.setVisible(true);
    }

    public int confirmacionBorrado(ActionEvent e) {
        return JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Está seguro de que desea borrar el usuario?");
    }

}