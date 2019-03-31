package com.nifelee.common.util;

import com.nifelee.common.Constants;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptUtil {

  private SecretKeySpec keySpec;

  private IvParameterSpec ivSpec;

  private Cipher cipher;

  private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

  private static final String KEY_STRING = "nifelee";

  private static final String IV_STRING = "nifelee";

  public static CryptUtil getInstance() {
    return CryptInitialization.getCryptUtil();
  }

  private CryptUtil() {
    byte[] keyBytes = ByteUtils.toBytes(KEY_STRING);
    byte[] ivBytes = ByteUtils.toBytes(IV_STRING);
    byte[] key = new byte[16];
    byte[] iv = new byte[16];

    System.arraycopy(keyBytes, 0, key, 0, key.length);
    System.arraycopy(ivBytes, 0, iv, 0, iv.length);

    this.keySpec = new SecretKeySpec(key, 0, 16, "AES");
    this.ivSpec = new IvParameterSpec(iv);
  }

  public String encrypt(String plainText) {
    try {
      this.cipher = Cipher.getInstance(ALGORITHM);
      this.cipher.init(Cipher.ENCRYPT_MODE, this.keySpec, this.ivSpec);
      byte[] plain = ByteUtils.toBytes(plainText);
      byte[] encrypt = this.cipher.doFinal(plain);
      return new String(Base64.encodeBase64(encrypt), Constants.DEFAULT_CHAR_SET);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public String decrypt(String encryptText) {
    if (encryptText.length() <= 0)
      return "";
    try {
      if (StringUtils.contains(encryptText, " ")) {
        encryptText = StringUtils.replace(encryptText, " ", "+");
      }
      this.cipher = Cipher.getInstance(ALGORITHM);
      this.cipher.init(Cipher.DECRYPT_MODE, this.keySpec, this.ivSpec);
      byte[] encrypt = Base64.decodeBase64(ByteUtils.toBytes(encryptText));
      byte[] plain = this.cipher.doFinal(encrypt);
      return new String(plain, Constants.DEFAULT_CHAR_SET);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private enum CryptInitialization {
    INSTANCE;

    public static CryptUtil getCryptUtil() {
      return new CryptUtil();
    }

  }

}
