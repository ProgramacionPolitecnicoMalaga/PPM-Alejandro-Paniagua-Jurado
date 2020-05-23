package com.politecnicomalaga.algoritmos;

import com.politecnicomalaga.control.GestorUsuarios;

import java.security.NoSuchAlgorithmException;

public class EncriptadorFactory {

    public static Encriptador obtenerEncriptador(String encriptado) {
        Encriptador encriptador = null;
        switch (encriptado) {
            case GestorUsuarios.ALGORITMO_BCRYPT:
                encriptador = new Bcrypt();
                break;
            case GestorUsuarios.ALGORITMO_SHA512:
                try {
                    encriptador = new SHA512();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                break;
        }
        return encriptador;
    }
}
