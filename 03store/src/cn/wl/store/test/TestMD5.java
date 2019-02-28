package cn.wl.store.test;

import org.junit.Test;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TestMD5 {
    @Test
    public void test() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update("李洪伟".getBytes());
        byte[] digest = md5.digest();
        System.out.println("digest: " + digest);
        System.out.println("长度:" + digest.length);

        String bigInteger = new BigInteger(1, digest).toString(16);
        System.out.println("bigInteger:" + bigInteger);

    }
}
