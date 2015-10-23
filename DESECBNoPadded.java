public class DESECBNoPadded extends BaseCipher {
    public static final String name  = "DES";
    public static final String specification = "DES/ECB/NoPadding";

    public static final int ivLength = 7; // 56 bits
    public static final int encryptionKeyLength = 7; // 56 bits

    public DESECBNoPadded(String encryptionKey, String iv) throws Exception {
        super(DESECBNoPadded.name, DESECBNoPadded.specification, new KeyPair(encryptionKey, iv, DESECBPadded.encryptionKeyLength, DESECBPadded.ivLength));
    }
}
