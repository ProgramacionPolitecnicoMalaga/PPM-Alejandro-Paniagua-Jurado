package com.politecnicomalaga.vista;
import com.politecnicomalaga.controlador.GestorUsuarios;
import com.politecnicomalaga.modelo.Usuario;
import com.politecnicomalaga.modelo.Validacion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UIPrincipal {
    private JPanel panelMain;
    private JButton validarButton;
    private JButton borrarButton;
    private JList listValidacion;
    private JList listNombres;
    private JButton registrarButton;
    private GestorUsuarios gestorUsuarios;
    private DataTransfer dataTransfer;
    private DefaultListModel<Validacion> modeloDatos;

    private final static int DIALOGO_REGISTRO_CORRECTO = 1;
    private final static int DIALOGO_USUARIO_REPETIDO = 2;
    private final static int DIALOGO_DATOS_INCORRECTOS = 3;
    private final static int DIALOGO_SELECCIONA_USUARIO = 4;

    public UIPrincipal(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
        actualizarListaNombres();
        registrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataTransfer = new DataTransfer();
                lanzarDialogo(new DialogoRegistrar(dataTransfer), e);
                String resultado = (String) dataTransfer.get("resultado");
                if (resultado.equals("correcto")) {
                    if (! gestorUsuarios.usuarioExistente((String) dataTransfer.get("nombre"))) {
                        gestorUsuarios.crearUsuario((String) dataTransfer.get("nombre"), (String) dataTransfer.get("contraseña"), (String) dataTransfer.get("algoritmo"));
                        mostrarMensajeDialogo(DIALOGO_REGISTRO_CORRECTO, e);
                        actualizarListaNombres();
                    }
                    else mostrarMensajeDialogo(DIALOGO_USUARIO_REPETIDO, e);
                }
                else if (resultado.equals("incorrecto")) mostrarMensajeDialogo(DIALOGO_DATOS_INCORRECTOS, e);
            }
        });
        validarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataTransfer = new DataTransfer();
                lanzarDialogo(new DialogoValidar(dataTransfer), e);
                String resultado = (String) dataTransfer.get("resultado");
                if (resultado.equals("correcto")) {
                    if ( gestorUsuarios.usuarioExistente((String) dataTransfer.get("nombre"))) {
                        dataTransfer.put("controlador", gestorUsuarios);
                        Validacion validacion = DataTransferAValidacion.transformar(dataTransfer);
                        modeloDatos.addElement(validacion);
                    }
                    else mostrarMensajeDialogo(DIALOGO_DATOS_INCORRECTOS, e);
                }
                else if (resultado.equals("incorrecto")) mostrarMensajeDialogo(DIALOGO_DATOS_INCORRECTOS, e);
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listNombres.getSelectedValue()!=null) {
                    int respuesta = mostrarConfirmacionBorrado(e);
                    if (respuesta == JOptionPane.OK_OPTION) {
                        ArrayList<String> listaNombres = (ArrayList<String>) listNombres.getSelectedValuesList();
                        gestorUsuarios.eliminarUsuario(listaNombres);
                        actualizarListaNombres();
                        actualizarListaNombres();
                    }
                }
                else mostrarMensajeDialogo(DIALOGO_SELECCIONA_USUARIO, e);
            }
        });
    }

    public void lanzarDialogo(JDialog dialogo, ActionEvent e) {
        dialogo.setLocationRelativeTo(SwingUtilities.getRoot((Component) e.getSource()));
        dialogo.pack();
        dialogo.setVisible(true);
    }

    public int mostrarConfirmacionBorrado(ActionEvent e) {
        return JOptionPane.showConfirmDialog(SwingUtilities.getRoot((Component) e.getSource()), "¿Borrar usuario/s seleccionado/s?");
    }

    public void mostrarMensajeDialogo(int tipo, ActionEvent e) {
        switch (tipo) {
            case DIALOGO_REGISTRO_CORRECTO:
                mensajeDialogo("Usuario registrado con éxito.", e);
                break;
            case DIALOGO_USUARIO_REPETIDO:
                mensajeDialogo("El usuario ya existe, elige otro nombre.", e);
                break;
            case DIALOGO_DATOS_INCORRECTOS:
                mensajeDialogo("Has introducido datos incorrectos o incompletos.", e);
                break;
            case DIALOGO_SELECCIONA_USUARIO:
                mensajeDialogo("Selecciona uno o más usuarios.", e);
                break;
        }
    }

    public void mensajeDialogo(String mensaje, ActionEvent e) {
        JOptionPane.showMessageDialog(SwingUtilities.getRoot((Component) e.getSource()), mensaje);
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void actualizarListaNombres() {
        actualizar( gestorUsuarios.getListaUsuarios());
    }

    public void actualizar(ArrayList<Usuario> listaCredenciales) {
        DefaultListModel<String> lstModel = new DefaultListModel<>();
        for (Usuario usuario : listaCredenciales) {
            lstModel.addElement(usuario.getNombre());
        }
        listNombres.setModel(lstModel);
    }

    private void createUIComponents() {
        listValidacion = new JList();
        modeloDatos = new DefaultListModel<>();
        listValidacion.setModel(modeloDatos);
        listValidacion.setCellRenderer(new ValidacionRender());
    }
}
