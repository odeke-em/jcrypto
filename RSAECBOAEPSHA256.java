public class RSAECBOAEPSHA256 extends BaseCipher {
    public static final String name  = "RSA";
    public static final String specification = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    public static final int ivLength = 256 ; // (1024, 2048) bits
    public static final int encryptionKeyLength = 256; // (1024, 2048) bits

    public RSAECBOAEPSHA256(String encryptionKey, String iv) throws Exception {
        super(RSAECBOAEPSHA256.name, RSAECBOAEPSHA256.specification, new KeyPair(encryptionKey, iv, RSAECBOAEPSHA256.encryptionKeyLength, RSAECBOAEPSHA256.ivLength));
    }
}
