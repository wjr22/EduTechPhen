package cn.nnu.jyjs.etpweb.service.ServiceImpl;

import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.mapper.UserMapper;
import cn.nnu.jyjs.etpweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * @Project :   etpweb
 * @Time :   9/1/2018 16:01
 * @Auther :   wangj
 * @Description:
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public User selectByName(String name) {
        User user = userMapper.selectByName(name);
        return user;
    }

    @Override
    public User selectByEmail(String email) {
        User user = userMapper.selectByEmail(email);
        return user;
    }

    @Override
    public User selectById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<String> insertInspect(User user) {
        List<String> msg=new LinkedList<String>();
        if(userMapper.selectByName(user.getUserName()) != null ){
            msg.add("");
            if(userMapper.selectByEmail(user.getUsereEmail()) != null){
                msg.add("");
            }else{

            }
        }else{

        }
        return msg;
    }

    @Override
    public void exitUser(int userId) {
        User user = userMapper.selectByPrimaryKey(userId);
        switch (user.getUserStatus()){
            case 0:
                // System Err
                break;
            case 1:
                userMapper.updateUserStatus(0,user.getUserId());
                break;
        }
    }

    @Override
    public void login(int userId) {
        userMapper.updateUserStatus(1,userId);
    }

    /**
     * @param userId
     * @return If userId is Signin : return true,or false
     */
    @Override
    public boolean islogin(int userId) {
        return userMapper.selectByPrimaryKey(userId).getUserStatus() == 1? true : false;
    }


}
