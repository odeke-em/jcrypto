import java.io.UnsupportedEncodingException;

public class KeyPair implements Cloneable {
    public String Iv;
    public String EncryptionKey;

    private int requiredIVLength = 16;
    private int requiredEncryptionKeyLength = 16;

    private void _KeyPair(String encKey, String iv) {
        this.Iv = iv;
        this.EncryptionKey = encKey;
    }

    public KeyPair(String encKey, String iv) throws Exception {
        this._KeyPair(encKey, iv);
        this.validate();
    }

    public KeyPair(String encKey, String iv, int requiredEncKeyLength, int requiredIVLength) throws Exception {
        this._KeyPair(encKey, iv);
        this.requiredIVLength  =  requiredIVLength;
        this.requiredEncryptionKeyLength = requiredEncKeyLength;

        this.validate();
    }

    private Exception checkIV(String v) {
        if (v == null || v.length() != this.requiredIVLength)
            return new Exception(String.format("iv must be set and of length %d", this.requiredIVLength));

        return null;
    }

    public Exception checkEncryptionKey(String v) {
        if (v == null || v.length() != this.requiredEncryptionKeyLength)
            return new Exception(String.format("encryptionkey must be set and of length %d", this.requiredEncryptionKeyLength));

        return null;
    }

    public void validate() throws Exception {
        Exception ivEx = this.checkIV(this.Iv);
        if (ivEx != null)
            throw ivEx;

        Exception encEx = this.checkEncryptionKey(this.Iv);
        if (encEx != null)
            throw encEx;
    }

    public void setEncryptionKey(String encKey) throws Exception {
        Exception ex = this.checkEncryptionKey(encKey);
        if (ex != null)
            throw ex;

        this.EncryptionKey = encKey;
    }

    public void setIv(String iv) throws Exception {
        Exception ex = this.checkIV(iv);
        if (ex != null)
            throw ex;

        this.Iv = iv;
    }

    public boolean ivEquals(String v) {
        return this.Iv.equals(v);
    }

    public boolean encryptionKeyEquals(String v) {
        return this.EncryptionKey.equals(v);
    }

    public static byte[] getUTF8Bytes(String v) throws UnsupportedEncodingException, Exception {
        return v.getBytes("UTF-8");
    }

    public byte[] encryptionKeyUTF8Bytes() throws UnsupportedEncodingException, Exception {
        return KeyPair.getUTF8Bytes(this.EncryptionKey);
    }

    public byte[] ivUTF8Bytes() throws UnsupportedEncodingException, Exception {
        return KeyPair.getUTF8Bytes(this.Iv);
    }

    @Override
    public Object clone() {
        KeyPair copy = null;
        try {
            copy = new KeyPair(this.EncryptionKey, this.Iv, this.requiredEncryptionKeyLength, this.requiredIVLength);
        } catch (Exception ex) {
            System.out.println("clone: err " + ex);
        }

        return copy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        KeyPair other = (KeyPair)obj;
        if (this.requiredIVLength != other.requiredIVLength)
            return false;

        if (this.requiredEncryptionKeyLength != other.requiredEncryptionKeyLength)
            return false;

        return this.Iv == other.Iv && this.EncryptionKey == other.EncryptionKey;
    }
}
