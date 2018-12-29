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
        String t2="System1";
        String t3="System2";
        String t4="System3";
        int a , b , c;
        a=28;b=15;c=(int)(a*1.0/b + 0.5);
        System.out.println(c);
        System.out.println(Encryption.getPsdCipher(t2));
        System.out.println(Encryption.getPsdCipher(t3));
        System.out.println(Encryption.getPsdCipher(t4));
    }
}
