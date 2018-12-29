package cn.nnu.jyjs.etpweb.mapper;

import cn.nnu.jyjs.etpweb.bean.User;
import cn.nnu.jyjs.etpweb.bean.Example.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer userId);

    User selectByName(String userName);

    User selectByEmail(String userEmail);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateUserStatus(@Param("userStatus") Integer userStatus, @Param("userId") Integer userId);
}