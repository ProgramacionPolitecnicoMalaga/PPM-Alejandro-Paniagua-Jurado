package com.politecnicomalaga;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarreraTest {
    private Carrera carrera;

    @Before
    public void setUp() {
        carrera=new Carrera();
    }

    @After
    public void tearDown() {
        carrera.finalizarCarrera();
    }

    @Test
    public void lista_ParticipantesIfEmptyIsNull() {
        assertNull(carrera.getListadoParticipantes());
    }

    @Test
    public void lista_ParticipantesIfNotEmptyIsNotNull() {
        carrera.addParticipante("Ale");
        assertNotNull(carrera.getListadoParticipantes());
    }

    @Test
    public void lista_ParticipantesPermite4ParticipantesDistintos() {
        assertTrue(carrera.addParticipante("Ale"));
        assertTrue(carrera.addParticipante("Juán"));
        assertTrue(carrera.addParticipante("Antonio"));
        assertTrue(carrera.addParticipante("Jose"));
    }

    @Test
    public void lista_ParticipantesAddParticipanteRepetido() {
        assertTrue(carrera.addParticipante("Ale"));
        assertTrue(carrera.addParticipante("Juán"));
        assertTrue(carrera.addParticipante("Antonio"));
        assertTrue(carrera.addParticipante("Jose"));
        boolean result=carrera.addParticipante("Ale");
        assertFalse(result);
        assertEquals(4, carrera.getTotalParticipantes());
    }

    @Test
    public void testGetAndSetPosicion() {
        String wick = "John Wick";
        carrera.addParticipante("Ale");
        carrera.addParticipante(wick);
        carrera.setPosicion(wick, 1);
        assertEquals(wick,carrera.getParticipantePorPosicion(1));
    }

    @Test
    public void NotEqualsGetAndClone() {
        List listaParticipantes = carrera.getListadoParticipantes();
        List listaParticipantesClone = carrera.cloneCarrera();
        assertNotEquals(listaParticipantes, listaParticipantesClone);
    }

    @Test
    public void finalizarCarrera() {
        assertTrue(carrera.addParticipante("Ale"));
        assertTrue(carrera.addParticipante("Juán"));
        assertTrue(carrera.addParticipante("Antonio"));
        assertTrue(carrera.addParticipante("Jose"));

        List listaParticipantesInicio = carrera.getListadoParticipantes();

        carrera.setPosicion("Ale", 1);
        carrera.setPosicion("Juán", 2);
        carrera.setPosicion("Antonio", 3);

        List listaParticipantesFinal = carrera.getListadoParticipantes();

        assertArrayEquals(listaParticipantesInicio.toArray(), listaParticipantesFinal.toArray());
    }
}