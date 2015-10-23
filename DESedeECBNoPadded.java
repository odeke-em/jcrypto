public class DESedeECBNoPadded extends BaseCipher {
    public static final String name  = "DES";
    public static final String specification = "DESede/ECB/NoPadding";

    public static final int ivLength = 21; // 168 bits
    public static final int encryptionKeyLength = 21; // 168 bits

    public DESedeECBNoPadded(String encryptionKey, String iv) throws Exception {
        super(DESedeECBNoPadded.name, DESedeECBNoPadded.specification, new KeyPair(encryptionKey, iv, DESedeECBNoPadded.encryptionKeyLength, DESedeECBNoPadded.ivLength));
    }
}
