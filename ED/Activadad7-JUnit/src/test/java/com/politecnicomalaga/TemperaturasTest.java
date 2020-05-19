package com.politecnicomalaga;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TemperaturasTest {

    @Test
    public void NoFuncionaMetodo() {
        Temperaturas temperaturas = new Temperaturas();
        Temperaturas espiaTemperaturas = spy(temperaturas);
        when(espiaTemperaturas.diferenciaMaxima()).thenReturn(30);//el fallo está que con el when/then return estas ejecutando el metodo diferenciaMaxima cuando la lista está vacia por eso
        assertEquals(30,espiaTemperaturas.diferenciaMaxima());
    }
    //el fallo está que con el when/then return estas ejecutando el metodo diferenciaMaxima cuando la lista está vacia por eso nos da el error de IndexOutOfBoundsException
    @Test
    public void EsteFunciona(){
        Temperaturas temperaturas = new Temperaturas();
        Temperaturas espiaTemperaturas = spy(temperaturas);
       doReturn(30).when(espiaTemperaturas).diferenciaMaxima();
        assertEquals(30,espiaTemperaturas.diferenciaMaxima());// con doReturn evitamso que el metodo diferenciamMaxima se ejecute en Temperaturas y nos de el error
    }
    // con doReturn evitamos que el método diferenciamMaxima se ejecute en Temperaturas y nos de el error de que la lista esté vacia
}