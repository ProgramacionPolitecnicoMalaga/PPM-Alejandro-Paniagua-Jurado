package com.politecnicomalaga.algoritmos;

import com.politecnicomalaga.control.GestorUsuarios;
import com.politecnicomalaga.modelo.Usuario;
import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class SHA512 implements Encriptador {

    MessageDigest messageDigest;

    public SHA512() throws NoSuchAlgorithmException {
        messageDigest = MessageDigest.getInstance("SHA-512");
    }

    public String getSalt(){
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);
            return Hex.encodeHexString(salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "Salt!";
        }
    }

    public String getSaltedContraseñaHash(String contraseña, String salt) {
        if (messageDigest == null)
            try {
                throw new NoSuchAlgorithmException("No existe el algoritmo de hash");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        messageDigest.update(salt.getBytes());
        byte[] bytes = messageDigest.digest(contraseña.getBytes());
        return new String(Hex.encodeHex(bytes));
    }

    public boolean verificarSaltedContraseña(String contraseña, String salt, String contraseñaHash) {
        String nuevoHash = getSaltedContraseñaHash(contraseña,salt);
        return nuevoHash.equals(contraseñaHash);
    }


    @Override
    public Usuario crearContraseña(String contraseña) {
        String salt = getSalt();
        return new Usuario(getSaltedContraseñaHash(contraseña,salt), GestorUsuarios.ALGORITMO_SHA512, salt);
    }

    @Override
    public boolean comprobarContraseña(String contraseña, Usuario usuario) {
        return verificarSaltedContraseña(contraseña, usuario.getSalt(),usuario.getHash());
    }
}
