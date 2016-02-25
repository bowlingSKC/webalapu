package webalapu.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class PasswordEncryption {

    public static String hashPassword(String plain) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(plain.getBytes("UTF-8"));
        byte[] digest = md.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        return bigInt.toString(16);
    }
}
