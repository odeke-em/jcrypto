public class DESECBPadded extends BaseCipher {
    public static final String name  = "DES";
    public static final String specification = "DES/ECB/PCKS5Padding";

    public static final int ivLength = 7; // 56 bits
    public static final int encryptionKeyLength = 7; // 56 bits

    public DESECBPadded(String encryptionKey, String iv) throws Exception {
        super("DES", "DES/ECB/PCKS5Padding", new KeyPair(encryptionKey, iv, DESECBPadded.encryptionKeyLength, DESECBPadded.ivLength));
    }
}
