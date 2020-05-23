package com.poltiecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CarreraTest {
    Carrera carrera;

    @Before
    public void setUp() throws Exception {
        carrera=new Carrera();
    }

    @Test
    public void listaEmptyNull() {
        assertNull(carrera.getListadoParticipantes());
        carrera.addParticipante(new Piloto(0, "Jose"));
        assertNotNull(carrera.getListadoParticipantes());
    }

    @Test
    public void add4Participantes() {
        assertTrue(carrera.addParticipante(new Piloto(1, "Jose")));
        assertTrue(carrera.addParticipante(new Piloto(2, "Paco")));
        assertTrue(carrera.addParticipante(new Piloto(3, "Ale")));
        assertTrue(carrera.addParticipante(new Piloto(4, "Mauri")));
    }

    @Test
    public void ParticipanteRepetido() {
       carrera.addParticipante(new Piloto(1, "Jose"));
        carrera.addParticipante(new Piloto(2, "Paco"));
        carrera.addParticipante(new Piloto(3, "Ale"));
        carrera.addParticipante(new Piloto(4, "Mauri"));

        assertFalse(carrera.addParticipante(new Piloto(1, "Jose")));
        int valorEsperado=4;
        assertEquals(valorEsperado, carrera.getTotalParticipantes());
    }

    @Test
    public void cloneCarrera() {
        inicializarLista();
        List listaGet=carrera.getListadoParticipantes();
        List listaClone=carrera.cloneCarrera();
        assertEquals(listaClone, listaGet);
    }

    @Test
    public void setPosicionWick() {
        Piloto wick=new Piloto(1,"wick");
        carrera.setPosicion(wick.getNombre(), 1);
        assertEquals(wick, carrera.getParticipantePorPosicion(1));
    }

    @Test
    public void cambiarPuestos() {
        Carrera carreraPrueba=new Carrera();
        carreraPrueba.addParticipante(new Piloto(1,"Jose"));
        carreraPrueba.addParticipante(new Piloto(2,"PAco"));
        carreraPrueba.addParticipante(new Piloto(3,"Ale"));
        carreraPrueba.addParticipante(new Piloto(4,"Antonio"));
        List lista1=carrera.getListadoParticipantes();
        carreraPrueba.setPosicion("Jose", 3);
        carreraPrueba.setPosicion("Antonio", 1);
        List lista2=carreraPrueba.getListadoParticipantes();
    }
    public void inicializarLista(){
        carrera.addParticipante(new Piloto(1, "Jose"));
        carrera.addParticipante(new Piloto(2, "Paco"));
    }
}