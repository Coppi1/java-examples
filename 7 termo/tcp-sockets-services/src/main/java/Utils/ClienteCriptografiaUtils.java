package Utils;

import java.util.Base64;

public class ClienteCriptografiaUtils {
    private static final byte CHAVE = 0x55;

    public static String criptografar(String texto) {
        byte[] bytes = texto.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= CHAVE;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }
}