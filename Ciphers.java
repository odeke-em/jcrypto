public class Ciphers {
    public static BaseCipher DESECBPadded(String encryptionKey, String iv) {
        return new BaseCipher("DES", "DES/ECB/PCKS5Padding", encryptionKey, iv, 7, 7);
    }
}
