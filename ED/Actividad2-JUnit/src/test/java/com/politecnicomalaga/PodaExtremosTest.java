package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

public class PodaExtremosTest {
    private PodaExtremos podaExtremos;
    private ArrayList<Integer> listaNumeros;
    private int resultadoEsperado;
    private int resultadoObtenido;
    @Before
    public void setUp() throws Exception {
        podaExtremos = new PodaExtremos();
        listaNumeros = new ArrayList<>();
        Collections.addAll(listaNumeros, 1,21,55,1,5,8,13,3,2,34);
    }

    @After
    public void tearDown() throws Exception {
        listaNumeros.clear();
    }
    public void getResultados(int esperado, int obtenido){
        resultadoEsperado = esperado;
        resultadoObtenido = obtenido;
    }

    @Test
    public void podarMasProximo() {
        getResultados(1, podaExtremos.podarMasProximo(2,listaNumeros));
        getResultados(5, podaExtremos.podarMasProximo(7,listaNumeros));
    }

    @Test
    public void podarMasLejano() {
        getResultados(55, podaExtremos.podarMasProximo(9,listaNumeros));
        getResultados(1, podaExtremos.podarMasProximo(30,listaNumeros));
    }
}