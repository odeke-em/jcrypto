public class DESCBCNoPadded extends BaseCipher {
    public static final String name  = "DES";
    public static final String specification = "DES/CBC/NoPadding";

    public static final int ivLength = 7; // 56 bits
    public static final int encryptionKeyLength = 7; // 56 bits

    public DESCBCNoPadded(String encryptionKey, String iv) throws Exception {
        super(DESCBCNoPadded.name, DESCBCNoPadded.specification, new KeyPair(encryptionKey, iv, DESCBCNoPadded.encryptionKeyLength, DESCBCNoPadded.ivLength));
    }
}
