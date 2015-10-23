public class DESCBCPadded extends BaseCipher {
    public static final String name  = "DES";
    public static final String specification = "DES/CBC/PKCS5Padding";

    public static final int ivLength = 7; // 56 bits
    public static final int encryptionKeyLength = 7; // 56 bits

    public DESCBCPadded(String encryptionKey, String iv) throws Exception {
        super(DESCBCPadded.name, DESCBCPadded.specification, new KeyPair(encryptionKey, iv, DESCBCPadded.encryptionKeyLength, DESCBCPadded.ivLength));
    }

}
