package cn.nnu.jyjs.etpweb.utils;

import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
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

    /**
     * 保存文件，直接以multipartFile形式
     *
     * @param multipartFile
     * @param path          文件保存绝对路径
     * @return 返回文件名
     * @throws IOException
     */
    public static String saveFile(MultipartFile multipartFile, String path, String fileName) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}
