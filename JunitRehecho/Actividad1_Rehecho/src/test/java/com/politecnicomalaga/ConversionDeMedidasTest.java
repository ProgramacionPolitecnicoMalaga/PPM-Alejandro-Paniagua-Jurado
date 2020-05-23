package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConversionDeMedidasTest {
        ConversionDeMedidas conversionDeMedidas;
    @Before
    public void setUp() throws Exception {
        conversionDeMedidas=new ConversionDeMedidas();
    }
    //1 inch = 2,54 cm
    //12 inch = 30,48 cm
    //12 cm = 4,72441 inc
    //0 cm = 0 inch
    //0,5 cm = 0,1968 inch

    @Test
    public void inchACm() {
        Double resultadoEsperado1=2.54;
        Double resultadoEsperado2=30.48;
        assertEquals(resultadoEsperado1, conversionDeMedidas.inchACm(1));
        assertEquals(resultadoEsperado2, conversionDeMedidas.inchACm(12));
    }

    @Test
    public void cmAInch() {
        Double resultadoEsperado1=4.724409448818897;
        Double resultadoEsperado2=0.0;
        Double resultadoEsperado3=0.19685039370078738;//algunos da error pero por decimales
        assertEquals(resultadoEsperado1, conversionDeMedidas.cmAInch(12));
        assertEquals(resultadoEsperado2, conversionDeMedidas.cmAInch(0));
        assertEquals(resultadoEsperado3, conversionDeMedidas.cmAInch(0.5));
    }
}