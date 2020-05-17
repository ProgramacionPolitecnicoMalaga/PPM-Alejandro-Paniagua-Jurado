package com.politecnicomalaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AccionSensorTest {
    private MatrizSensores matrizSensores;

    @Before
    public void setUp() throws Exception {
        matrizSensores = mock(MatrizSensores.class);
        GrupoSensores grupoNoIniciados = new GrupoSensores(Sensor.NO_INICIADO);
        GrupoSensores grupoVacio = new GrupoSensores(Sensor.ESTADO_VACIO);
        GrupoSensores grupoCasiVacio = new GrupoSensores(Sensor.ESTADO_CASI_VACIO);
        GrupoSensores grupoMitad = new GrupoSensores(Sensor.ESTADO_MITAD);
        GrupoSensores grupoCasiLleno = new GrupoSensores(Sensor.ESTADO_CASI_LLENO);
        GrupoSensores grupoLleno = new GrupoSensores(Sensor.ESTADO_LLENO);

        when(matrizSensores.getEstadoSensor(intThat(grupoVacio))).thenReturn(Sensor.ESTADO_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(grupoCasiVacio))).thenReturn(Sensor.ESTADO_CASI_VACIO);
        when(matrizSensores.getEstadoSensor(intThat(grupoMitad))).thenReturn(Sensor.ESTADO_MITAD);
        when(matrizSensores.getEstadoSensor(intThat(grupoCasiLleno))).thenReturn(Sensor.ESTADO_CASI_LLENO);
        when(matrizSensores.getEstadoSensor(intThat(grupoLleno))).thenReturn(Sensor.ESTADO_LLENO);
        doThrow(IllegalStateException.class).when(matrizSensores).getEstadoSensor(intThat(grupoNoIniciados));
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaBaja() {
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_BAJA);

        int resultadoEsperado = AccionSensor.ACCION_REVISION;
        int resultadoObtenido = accionSensor.evaluar(8);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(13);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(28);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_INNECESARIA;
        resultadoObtenido = accionSensor.evaluar(36);

        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaMedia() {
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_MEDIA);

        int resultadoEsperado = AccionSensor.ACCION_REVISION;
        int resultadoObtenido = accionSensor.evaluar(6);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(16);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(25);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(39);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_INNECESARIA;
        resultadoObtenido = accionSensor.evaluar(59);

        assertEquals(resultadoEsperado, resultadoObtenido);
    }

    @Test
    public void AccionesCorrectasParaLosSensoresEnDemandaAlta() {
        AccionSensor accionSensor = new AccionSensor(matrizSensores);
        accionSensor.setNivelDemanda(AccionSensor.DEMANDA_ALTA);

        int resultadoEsperado = AccionSensor.ACCION_REVISION;
        int resultadoObtenido = accionSensor.evaluar(2);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(19);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(23);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(38);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_REPOSICION;
        resultadoObtenido = accionSensor.evaluar(45);

        assertEquals(resultadoEsperado, resultadoObtenido);

        resultadoEsperado = AccionSensor.ACCION_INNECESARIA;
        resultadoObtenido = accionSensor.evaluar(51);

        assertEquals(resultadoEsperado, resultadoObtenido);
    }
}