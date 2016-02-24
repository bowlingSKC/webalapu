package webalapu.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncryption {

    public static String hashPassword(String plain) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String text = "test";
        md.update(text.getBytes("UTF-8"));
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        return bigInt.toString(16);
    }
}
