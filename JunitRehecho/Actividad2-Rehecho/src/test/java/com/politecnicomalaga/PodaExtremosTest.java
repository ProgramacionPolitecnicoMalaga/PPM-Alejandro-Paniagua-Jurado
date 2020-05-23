package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PodaExtremosTest {
    PodaExtremos podaExtremos;
    ArrayList<Integer>listaNumeros;
    // {1,21,55,1,5,8,13,3,2,34}

    @Before
    public void setUp() throws Exception {
        podaExtremos=new PodaExtremos();
        listaNumeros=new ArrayList<>();
        listaNumeros.add(1);
        listaNumeros.add(21);
        listaNumeros.add(55);
        listaNumeros.add(1);
        listaNumeros.add(5);
        listaNumeros.add(8);
        listaNumeros.add(13);
        listaNumeros.add(3);
        listaNumeros.add(2);
        listaNumeros.add(34);
    }

    @After
    public void tearDown() throws Exception {
        listaNumeros.clear();
    }

    @Test
    public void podarMasProximo() {
        int resultadoEsperado1=8;
        int resultadoObtenido1=podaExtremos.podarMasProximo(9,listaNumeros);
        assertEquals(resultadoEsperado1, resultadoObtenido1);
        int resultadoEsperado2=55;
        int resultadoObtenido2=podaExtremos.podarMasProximo(49,listaNumeros);
        assertEquals(resultadoEsperado2, resultadoObtenido2);
    }

    @Test
    public void podarMasLejano() {
        int resultadoEsperado1=55;
        int resultadoObtenido1=podaExtremos.podarMasLejano(10,listaNumeros);
        assertEquals(resultadoEsperado1, resultadoObtenido1);
        int resultadoEsperado2=1;
        int resultadoObtenido2=podaExtremos.podarMasLejano(30,listaNumeros);
        assertEquals(resultadoEsperado2, resultadoObtenido2);
    }
}