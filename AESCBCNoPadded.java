public class AESCBCNoPadded extends BaseCipher {
    public AESCBCNoPadded(String encryptionKey, String iv) throws Exception {
        super("AES", "AES/CBC/NoPadding", encryptionKey, iv);
    }
}
