package kz.pro2.webtask.action;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAction {
    private static final String STRING_BLANK = "";
    private static final String ALGORITHM = "SHA-1";
    private static final String CHAR_SET_NAME = "utf-8";

    /**
     * This method is used to encrypt user information before sending it to be stored in database
     *
     * @param plaintext String of plaintext which will be encrypted
     * @return if everything fine, return String of ciphertext,
     * else if plaintext is null of blank, will return blank String
     * in case of exception, will return blank String
     */
    public static String encryptInput(String plaintext) {
        if (plaintext == null || plaintext.isBlank()) {
            return STRING_BLANK;
        }
        byte[] bytes;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            messageDigest.update(plaintext.getBytes(CHAR_SET_NAME));
            bytes = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, bytes);
            return bigInteger.toString(16);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return STRING_BLANK;
    }
}
