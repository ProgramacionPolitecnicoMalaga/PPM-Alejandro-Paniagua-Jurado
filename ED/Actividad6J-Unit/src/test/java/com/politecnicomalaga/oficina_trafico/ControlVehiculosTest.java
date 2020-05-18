package com.politecnicomalaga.oficina_trafico;

import com.politecnicomalaga.DAO.TraficoDAO;
import com.politecnicomalaga.modelo.Persona;
import com.politecnicomalaga.modelo.Vehiculo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControlVehiculosTest {
    private ControlVehiculos controlVehiculos;
    private TraficoDAO traficoDAO;

    @Before
    public void setUp() {
        traficoDAO = mock(TraficoDAO.class);
        controlVehiculos = new ControlVehiculos(traficoDAO);
        when(traficoDAO.getVehiculoByMatricula("1234ABC")).thenReturn(new Vehiculo("1234ABC", "12345678A"));
        when(traficoDAO.getPropietarioByDNI("12345678A")).thenReturn(new Persona("José Pérez", "12345678A"));
    }

    @Test
    public void getPropietarioVehiculoTest() {
        InOrder inOrder = Mockito.inOrder(traficoDAO);
        inOrder.verify(traficoDAO).getVehiculoByMatricula("1234ABC");
        inOrder.verify(traficoDAO).getPropietarioByDNI("12345678A");
        verifyNoMoreInteractions(traficoDAO);
        Persona personaObtenida = controlVehiculos.getPropietarioVehiculo("1234ABC");
        assertEquals(personaObtenida, new Persona("José Pérez", "12345678A"));
    }
}