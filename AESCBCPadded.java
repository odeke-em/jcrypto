public class AESCBCPadded extends BaseCipher {
    public AESCBCPadded(String encryptionKey, String iv) throws Exception {
        super("AES", "AES/CBC/PKCS5Padding", encryptionKey, iv);
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        // TODO: finish me
        return false;
    }
}
