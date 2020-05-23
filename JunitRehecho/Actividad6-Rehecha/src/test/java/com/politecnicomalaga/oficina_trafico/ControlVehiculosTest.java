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
    ControlVehiculos controlVehiculos;
    TraficoDAO mockTraficoDAO;

    @Before
    public void setUp() throws Exception {
        mockTraficoDAO= mock(TraficoDAO.class);
        controlVehiculos=new ControlVehiculos(mockTraficoDAO);

        when(mockTraficoDAO.getVehiculoByMatricula("1234ABC")).thenReturn(new Vehiculo("1234ABC", "12345678A"));
        when(mockTraficoDAO.getPropietarioByDNI("12345678A")).thenReturn(new Persona("José Pérez", "12345678A"));
    }

    @Test
    public void getPropietarioVehiculo() {
        Persona personaObtenida=controlVehiculos.getPropietarioVehiculo("1234ABC");
        InOrder inOrder= Mockito.inOrder(mockTraficoDAO);
        //En primer lugar se ejecuta el método getVehiculoByMatricula("1234ABC") del objeto de tipo TraficoDAO en ControlVehiculos
        inOrder.verify(mockTraficoDAO).getVehiculoByMatricula("1234ABC");
        //En segundo lugar se ejecuta getPropietarioByDNI("12345678A") del objeto de tipo TraficoDAO en ControlVehiculos
        inOrder.verify(mockTraficoDAO).getPropietarioByDNI("12345678A");
        //Después no se producen más interaciones con el objeto de tipo TraficoDAO en ControlVehiculos
        verifyNoMoreInteractions(mockTraficoDAO);
        //El objeto devuelto por getVehiculoByMatricula es el esperado.
        Persona personaEsperada=new Persona("José Pérez", "12345678A");
        assertEquals(personaObtenida, personaEsperada);

    }
}