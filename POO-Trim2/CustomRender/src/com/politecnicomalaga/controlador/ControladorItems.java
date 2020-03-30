package com.politecnicomalaga.controlador;

import com.politecnicomalaga.dao.ItemDAO;
import com.politecnicomalaga.modelo.Item;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ControladorItems {
    public static final int IT = 1;
    public static final int DESARROLLO = 2;
    public static final int MANTENIMIENTO = 3;
    public static final int GENERAL = 4;

    ItemDAO itemDAO;

    public ControladorItems() {
        itemDAO = new ItemDAO();
    }

    public static String getTema (int tema) {
        switch (tema) {
            case IT:
                return "IT";
            case DESARROLLO:
                return "Desarrollo";
            case MANTENIMIENTO:
                return "Mantenimiento";
            case GENERAL:
                return "General";
            default: return "IT";
        }
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> listaEmpleados = new ArrayList<>();
        try {
            listaEmpleados = itemDAO.getItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEmpleados;
    }

    public void eliminarItem(int idItem) {
        try {
            itemDAO.borrar(idItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearItem(String autor, String tema, LocalDate fecha, String texto) {
        try {
            itemDAO.crear(new Item(autor, tema, fecha, texto));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
