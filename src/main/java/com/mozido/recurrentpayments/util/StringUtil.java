package com.mozido.recurrentpayments.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Random;

/**
 * Created by Rafael Richards on 06/25.
 */

public class StringUtil {
    private static final String UNICODE_FORMAT = "UTF8";
    private static final String ENCRYPTION_SCHEME = "DESede";
    private static Cipher cipher;
    private static SecretKey key;
    private static char[] ALLAOW_URL_CHARACTERS = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s',
            't','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V',
            'W','X','Y','Z','0','1','2','3','4','5','6','7','8','9','_','.','-','~'};

    static {
        KeySpec ks;
        SecretKeyFactory skf;
        byte[] arrayBytes;
        String myEncryptionKey = encrypt("f7a9712f899cc45f05321c6f04f90829", "f7a9712f899cc45f05321c6f04f90829");
        String myEncryptionScheme = ENCRYPTION_SCHEME;

        try{
            arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
            ks = new DESedeKeySpec(arrayBytes);
            skf = SecretKeyFactory.getInstance(myEncryptionScheme);
            cipher = Cipher.getInstance(myEncryptionScheme);
            key = skf.generateSecret(ks);
        } catch (Exception e){
            System.out.println(e.toString());
        }

    }



    public static byte[] encryptFile(byte[] unencryptedString) {
//        String encryptedString = null;
        byte[] encryptedText = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString;
            encryptedText = cipher.doFinal(plainText);
//            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return encryptedString.getBytes();
        return encryptedText;
    }


    public static byte[] decryptFile(byte[] encryptedText) {
        String decryptedText=null;
        byte[] plainText = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] encryptedText = Base64.decodeBase64(encryptedString.getBytes());
            plainText = cipher.doFinal(encryptedText);
            decryptedText= new String(plainText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return plainText;
    }

    static public boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    static public String encrypt(String text, String salt){
        try {
            // Create key and cipher
            String key = getGenerateKey(salt);
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] cipherText = cipher.doFinal(text.getBytes("UTF-8"));
            return Base64.encodeBase64String(cipherText);
        } catch (Exception e) {
            return "";
        }
    }

    private static String getGenerateKey(String salt){
        StringBuffer key = new StringBuffer(new String(Base64.encodeBase64(salt.getBytes())));
        int i = 0;
        if(key.length() > 32){
            return key.substring(0,32);
        }

        while(key.length() < 32){
            key.append(key.subSequence(i,i+1));
            i++;
        }
        return key.toString();
    }

    static public String decrypt(String text, String salt){
        try {
            // Create key and cipher
            String key = getGenerateKey(salt);
            Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            // decrypt the text
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] cipherText = cipher.doFinal(Base64.decodeBase64(text));
            return new String(cipherText);
        } catch (Exception e) {
            return "";
        }
    }

    public String generateURL(int length){
        StringBuffer s = new StringBuffer();
        Random r = new Random(System.currentTimeMillis());
        for(int i=0; i<length; i++){
            s.append(ALLAOW_URL_CHARACTERS[r.nextInt(ALLAOW_URL_CHARACTERS.length)]);
        }
        return s.toString();
    }

    static public boolean isNumeric(String s) {
        return !isEmpty(s) && s.matches("[-+]?\\d*\\.?\\d+");
    }

    public static boolean isNumericNew(String str) {
        if (str == null) {
            return false;
        }
        int sz = str.length();
        for (int i = 0; i < sz; i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    static public String generatePin(int length)
    {
        StringBuffer s = new StringBuffer();
        Random r = new Random(System.currentTimeMillis());
        for(int i=0; i<length; i++){
            s.append(r.nextInt(9));
        }
        return s.toString();
    }
}
