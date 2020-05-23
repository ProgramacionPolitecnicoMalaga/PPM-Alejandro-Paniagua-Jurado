package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TurnoTest {
    Turno turnoMock;


    @Before
    public void setUp() throws Exception {
        turnoMock=mock(Turno.class);
        when(turnoMock.siguiente(0)).thenReturn(1);
        when(turnoMock.siguiente(4)).thenReturn(5);
        when(turnoMock.siguiente(1)).thenReturn(2);
    }

    @Test
    public void siguiente() {
        int siguienteObtenido=turnoMock.siguiente(0);
        int siguienteEsperado=1;
        assertEquals(siguienteEsperado, siguienteObtenido);
        int siguienteObtenido2=turnoMock.siguiente(4);
        int siguienteEsperado2=5;
        assertEquals(siguienteEsperado2, siguienteObtenido2);
        int siguienteObtenido3=turnoMock.siguiente(1);
        int siguienteEsperado3=2;
        assertEquals(siguienteEsperado3, siguienteObtenido3);
    }
}