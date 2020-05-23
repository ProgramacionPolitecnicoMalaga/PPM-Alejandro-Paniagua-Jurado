package com.politecnicomalaga;

import java.util.List;

public class PodaExtremos {
    int podarMasProximo(int numero, List<Integer> listaNumeros){
        int diferenciaMAxima=Integer.MAX_VALUE;
        int posicionDeNumero=0;
        for (int i=0; i<listaNumeros.size(); i++){
            int diferenciaCalculada=Math.abs(listaNumeros.get(i)-numero);
            if (diferenciaCalculada< diferenciaMAxima){
                diferenciaMAxima=diferenciaCalculada;
                posicionDeNumero=i;
            }
        }
        return listaNumeros.remove(posicionDeNumero);
    }
    int podarMasLejano(int numero, List<Integer> listaNumeros) {
        int diferenciaMinima = Integer.MIN_VALUE;
        int posicionDeNumero = 0;
        for (int i = 0; i < listaNumeros.size(); i++) {
            int diferenciaCalculada = Math.abs(listaNumeros.get(i) - numero);
            if (diferenciaCalculada > diferenciaMinima) {
                diferenciaMinima = diferenciaCalculada;
                posicionDeNumero = i;
            }
        }
        return listaNumeros.remove(posicionDeNumero);
    }
}
