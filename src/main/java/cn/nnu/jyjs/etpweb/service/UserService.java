package cn.nnu.jyjs.etpweb.service;

import cn.nnu.jyjs.etpweb.bean.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Project :   etpweb
 * @Time :   9/1/2018 16:00
 * @Auther :   wangj
 * @Description:
 */
public interface UserService {
    User selectByName(String name);
    User selectByEmail(String email);
    List<String> insertInspect(User user);
    void exitUser(HttpServletRequest request);
}
