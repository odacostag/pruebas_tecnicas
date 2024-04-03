package configuration.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class General {

    public static String encryptPassword(String password) {
        try {
            // Crear un objeto MessageDigest para SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Aplicar el hash a la contraseña
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convertir bytes hash a representación hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
