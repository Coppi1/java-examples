package Utils;

import java.util.Base64;

public class ServerCriptografiaUtils {
    private static final byte CHAVE = 0x55; // Mesma chave usada no cliente

    public static String descriptografar(String textoCriptografado) {
        byte[] bytes = Base64.getDecoder().decode(textoCriptografado);
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] ^= CHAVE;
        }
        return new String(bytes);
    }
}
