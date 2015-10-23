public class RSAECBOAEPSHA1 extends BaseCipher {
    public static final String name  = "RSA";
    public static final String specification = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";

    public static final int ivLength = 256 ; // (1024, 2048) bits
    public static final int encryptionKeyLength = 256; // (1024, 2048) bits

    public RSAECBOAEPSHA1(String encryptionKey, String iv) throws Exception {
        super(RSAECBOAEPSHA1.name, RSAECBOAEPSHA1.specification, new KeyPair(encryptionKey, iv, RSAECBOAEPSHA1.encryptionKeyLength, RSAECBOAEPSHA1.ivLength));
    }
}
