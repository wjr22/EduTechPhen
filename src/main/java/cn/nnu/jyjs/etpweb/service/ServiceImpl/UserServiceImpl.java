package cn.nnu.jyjs.etpweb.service.ServiceImpl;

import cn.nnu.jyjs.etpweb.mapper.UserMapper;
import cn.nnu.jyjs.etpweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project :   etpweb
 * @Time :   9/1/2018 16:01
 * @Auther :   wangj
 * @Description:
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


}
