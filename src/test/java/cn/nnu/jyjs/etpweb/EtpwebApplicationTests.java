package cn.nnu.jyjs.etpweb;

import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.service.UserService;
import cn.nnu.jyjs.etpweb.utils.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EtpwebApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        User user = userService.selectByName("test");
        if(user == null){
            System.out.println("null");
        }else{
            System.out.println(user.toString());
        }
    }

}
