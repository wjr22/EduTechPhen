package cn.nnu.jyjs.etpweb.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Project :   etpweb
 * @Time :   9/5/2018 22:25
 * @Auther :   wangj
 * @Description:  Single Design Pattern.
 *      HOW TO USE : Encryption instance = Encryption.getInstance().
 */
public class Encryption {

    /* instance */
    private static Encryption instance;
    /* password suffix */
    private static String PASSWORD_SUFFIX = "5f4dcc3b5aa765d61d8327deb882cf99";
    private Encryption(){
    }

    public static Encryption getInstance(){
        if(instance == null){
            synchronized (Encryption.class){
                instance = new Encryption();
            }
        }
        return instance;
    }

    /**
     *  This method is used to obtain the encrypted ciphertext of the password
     * @param password To be encrypted
     * @return
     */
    public static String getPsdCipher(String password){
        String result = "";
        password += PASSWORD_SUFFIX;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64Encoder = new BASE64Encoder();
            result = base64Encoder.encode(md5.digest(password.getBytes("utf-8")));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

}
