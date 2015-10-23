import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.NoSuchAlgorithmException;

public class BaseCipher {
    private String name;
    private String specification;

    private KeyPair keypair = null;
    private Cipher innardCipher = null;

    public BaseCipher(String name, String specification, String encryptionKey, String iv) throws NoSuchAlgorithmException, Exception {
        this.name = name;
        this.specification = specification;
        this.keypair = new KeyPair(encryptionKey, iv);

        if (this.keypair == null)
            throw new Exception("keyPair not initialized! must be non-null");

        this.initInnardCipher();
    }

    public BaseCipher(String name, String specification, KeyPair kp) throws NoSuchAlgorithmException, Exception {
        if (kp == null)
            throw new Exception("keyPair not initialized! must be non-null");

        this.keypair = (KeyPair)kp.clone();
        if (this.keypair == null)
            throw new Exception("keyPair not initialized! must be non-null");

        this.name = name;
        this.specification = specification;
        this.initInnardCipher();
    }

    private void initInnardCipher() throws Exception {
        this.innardCipher = Cipher.getInstance(this.specification);
    }

    public void setIv(String v) throws Exception {
        this.keypair.setIv(v);
    }

    public void setEncryptionKey(String v) throws Exception {
        this.keypair.setEncryptionKey(v);
    };

    public boolean ivEquals(String v) {
        return this.keypair.ivEquals(v);
    }

    public boolean encryptionKeyEquals(String v) {
        return this.keypair.encryptionKeyEquals(v);
    }

    private byte[] cipherOp(String dataIn, boolean decrypting) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(this.keypair.encryptionKeyUTF8Bytes(), this.name);
        IvParameterSpec ivSpec = new IvParameterSpec(this.keypair.ivUTF8Bytes());

        int mode = Cipher.ENCRYPT_MODE;
        if (decrypting)
            mode = Cipher.DECRYPT_MODE;

        this.innardCipher.init(mode, keySpec, ivSpec);

        return this.innardCipher.doFinal(KeyPair.getUTF8Bytes(dataIn));
    }

    public byte[] encrypt(final String plainText) throws Exception {
        return this.cipherOp(plainText, false);
    }

    public byte[] decrypt(final String cipherText) throws Exception {
        return this.cipherOp(cipherText, true);
    }

    public String specification() {
        return this.specification;
    }

    public String name() {
        return this.name;
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
