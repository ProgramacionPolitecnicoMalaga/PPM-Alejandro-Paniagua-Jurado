package com.politecnico;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplicadorTest {
    Multiplicador multiplicador;

    @Before
    public void setUp() throws Exception {
        multiplicador=new Multiplicador();
    }

    @Test
    public void multiplicar() {
        try {
            multiplicador.multiplicar(1000,2);
        }catch (IllegalArgumentException illegal){
            assertEquals("X debe ser menor que 1000", illegal.getMessage());
        }
    }
}