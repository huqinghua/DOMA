package com.github.hqh.mgm.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/**
 * @Description:
 * @author huqinghua
 */
public class Md5Util {
    public static Charset UTF_8 = Charset.forName("UTF-8");

    /**
     * 检查AES密钥是否符合规范
     * @param inKey 密钥
     * @throws Exception
     */
    private static boolean checkKeyLen(String inKey) {
        byte[] key = inKey.getBytes();
        if (key.length < 16 || (key.length % 16) != 0) {
            return false;
        }
        return true;
    }

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            resultSb.append(hex);
        }
        return resultSb.toString();
    }

    public static byte[] toBytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    /**
     * MD5 摘要计算(String UTF-8).
     * @param src 待加签字符串
     * @return 加签后字符串
     */
    public static String md5Digest (String src) {
        try {
            return byteArrayToHexString(
                    MessageDigest.getInstance("MD5").digest(src.getBytes(UTF_8)));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * MD5 摘要计算(String).
     * @param src 待加签字符串
     * @return 加签后字符串
     */
    public static String md5DigestGBK(String src) {
        try {
            return byteArrayToHexString(
                    MessageDigest.getInstance("MD5").digest(src.getBytes("GBK")));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * AES加密, 模式AES/ECB/PKCS5Padding
     * @param str 待加密明文字符串
     * @param key 加密密钥
     * @return 密文后字符串
     */
    public static String aesEncrypt(String str, String key) {
        if (checkKeyLen(key)) {
            try {
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] cipherText = cipher.doFinal(str.getBytes());
                return byteArrayToHexString(cipherText);
            } catch (Exception e) {
                return "";
            }
        }

        return "";
    }

    /**
     * AES解密加密, 模式AES/ECB/PKCS5Padding
     * @param str 待解密字符串
     * @param key 加密密钥
     * @return 密文后字符串
     */
    public static String aesDecrept(String str, String key) {
        if (checkKeyLen(key)) {
            try {
                byte[] binStr = toBytes(str);
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
                SecretKey secretKey = new SecretKeySpec(key.getBytes(), "AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] plainText = cipher.doFinal(binStr);
                return new String(plainText);
            } catch (Exception e) {
                return "";
            }
        }

        return "";
    }
}
