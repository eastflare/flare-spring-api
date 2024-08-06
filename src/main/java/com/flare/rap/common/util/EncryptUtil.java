package com.flare.rap.common.util;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import jakarta.servlet.http.HttpServletRequest;

public final class EncryptUtil {
    public static final String ENCRYPT_ALGORITHM = "AES";
    private EncryptUtil() {
        throw new AssertionError();
    }

    public static String encryptText(String text, String encryptKey) {
        String encrypted = "";
        if (text.equals("") || text == null)
            return "";
        try {
            SecretKeySpec ks = new SecretKeySpec(generateKey(encryptKey), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, ks);
            byte[] encryptedBytes = cipher.doFinal(text.getBytes());
            encrypted = new String(Base64Coder.encode(encryptedBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    public static String decryptText(String text, String encryptKey) {
        String decrypted = "";
        if (text.equals("") || text == null)
            return "";
        try {
            SecretKeySpec ks = new SecretKeySpec(generateKey(encryptKey), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, ks);
            byte[] decryptedBytes = cipher.doFinal(Base64Coder.decode(text));
            decrypted = new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decrypted;
    }

    private static byte[] generateKey(String key) {
        byte[] desKey = new byte[16];
        byte[] bkey = key.getBytes();
        if (bkey.length < desKey.length) {
            System.arraycopy(bkey, 0, desKey, 0, bkey.length);
            for (int i = bkey.length; i < desKey.length; i++)
                desKey[i] = 0;
        } else {
            System.arraycopy(bkey, 0, desKey, 0, desKey.length);
        }
        return desKey;
    }

    public static String encryptSha(String text) {
        String encrypted = "";
        if (text.equals("") || text == null)
            return "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes(StandardCharsets.UTF_8));
            byte[] digested = md.digest();
            encrypted = new String(Base64Coder.encode(digested));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    public static String parseEncCookies(String cookieName, HttpServletRequest httpRequest) {
        String cookieString = httpRequest.getHeader("COOKIE");
        if (cookieString == null)
            cookieString = httpRequest.getHeader("Cookie");
        if (cookieString == null)
            cookieString = httpRequest.getHeader("cookie");
        if (cookieString == null)
            return null;
        return parseEncCookies(cookieName, cookieString);
    }

    public static String parseEncCookies(String cookieName, String cookieHeader) {
        try {
            String cookieValue = null;
            if (cookieHeader != null) {
                String[] cookiesRaw = cookieHeader.split("; ");
                for (int i = 0; i < cookiesRaw.length; i++) {
                    String[] parts = cookiesRaw[i].split("=", 2);
                    String value = (parts.length > 1) ? parts[1] : "";
                    if (value.length() >= 2 && value.startsWith("\"") && value.endsWith("\""))
                        value = value.substring(1, value.length() - 1);
                    if (parts[0].equals(cookieName)) {
                        cookieValue = URLDecoder.decode(value, StandardCharsets.UTF_8);
                        return cookieValue.replace(' ', '+');
                    }
                }
            }
            return cookieValue;
        } catch (Exception e) {
            return "";
        }
    }
}