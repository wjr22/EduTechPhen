package cn.nnu.jyjs.etpweb;

import cn.nnu.jyjs.etpweb.utils.Encryption;
import org.junit.Test;

/**
 * @Project :   etpweb
 * @Time :   9/5/2018 22:51
 * @Auther :   wangj
 * @Description:
 */
public class EncryptionTest {
    public static void main(String[] args){
        Encryption encryption = Encryption.getInstance();
        String password = "admin";
        String t2="asdf";
        System.out.println(Encryption.getPsdCipher(password));
        System.out.println(Encryption.getPsdCipher(t2));
    }
}
