public class AESCBCNoPadded extends BaseCipher {
    public static final String name  = "AES";
    public static final String specification = "AES/CBC/NoPadding";

    public static final int ivLength = 16; // 128  bits
    public static final int encryptionKeyLength = 16; // 128 bits

    public AESCBCNoPadded(String encryptionKey, String iv) throws Exception {
        super(AESCBCNoPadded.name, AESCBCNoPadded.specification, new KeyPair(encryptionKey, iv, AESCBCNoPadded.encryptionKeyLength, AESCBCNoPadded.ivLength));
    }

}
