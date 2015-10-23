public class DESedeECBPadded extends BaseCipher {
    public static final String name  = "DES";
    public static final String specification = "DESede/ECB/PKCS5Padding";

    public static final int ivLength = 21; // 168 bits
    public static final int encryptionKeyLength = 21; // 168 bits

    public DESedeECBPadded(String encryptionKey, String iv) throws Exception {
        super(DESedeECBPadded.name, DESedeECBPadded.specification, new KeyPair(encryptionKey, iv, DESedeECBPadded.encryptionKeyLength, DESedeECBPadded.ivLength));
    }
}
