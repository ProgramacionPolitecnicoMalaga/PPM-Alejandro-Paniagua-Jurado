package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicadorTest {
    Multiplicador multiplicador;

    @Before
    public void setUp() throws Exception {
        multiplicador=new Multiplicador();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExcepcion(){
        multiplicador.multiplicar(1000,2);
    }

    @Test
    public void multiplicar() {
        int valorEsperado=4;
        int valorObtenido=multiplicador.multiplicar(2,2);
        assertEquals(valorEsperado, valorObtenido);
    }
}