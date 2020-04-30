package com.poltiecnicomalaga.Adapter;

import com.poltiecnicomalaga.Modelo.Persona;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class Adaptador extends AbstractTableModel {

    private final static int NOMBRE=0;
    private final static int APELLIDO=1;
    private final static int EDAD=2;

    private ArrayList<Persona> personas;
    private final static String[] nombreColumnas={"Nombre", "Apellido", "Edad"};

    public Adaptador(ArrayList<Persona> personas){
        this.personas=personas;
    }
    @Override
    public int getRowCount() {
        return personas.size();
    }

    @Override
    public int getColumnCount() {
        return nombreColumnas.length;
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        switch (columna){
            case NOMBRE:
                return personas.get(fila).getNombre();
            case APELLIDO:
                return personas.get(fila).getApellido();
            case EDAD:
                return personas.get(fila).getEdad();
            default:return null;
        }
    }
    @Override
    public String getColumnName(int columna) {
        return nombreColumnas[columna];
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case NOMBRE:
            case APELLIDO:
                return String.class;
            case EDAD:
                return Integer.class;
            default: return null;
        }
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch(columnIndex) {
            case NOMBRE:
                personas.get(rowIndex).setNombre((String) aValue);
                break;
            case APELLIDO:
                personas.get(rowIndex).setApellido((String) aValue);
                break;
            case EDAD:
                personas.get(rowIndex).setEdad((int) aValue);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    public void addRow(){
        personas.add(new Persona("","",0));
        fireTableDataChanged();
    }
    public void removeRow(int row){
        personas.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
