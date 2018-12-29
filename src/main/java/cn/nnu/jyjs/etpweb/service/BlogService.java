package cn.nnu.jyjs.etpweb.service;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.BlogSet;

import java.util.List;

/**
 * @Project :   etpweb
 * @Time :   9/5/2018 22:15
 * @Auther :   wangj
 * @Description:
 */
public interface BlogService {
    int insertBlog(Blog record,int userId,int categoryId);
    int insert(Blog blog);
    List<Blog> selectByCategory(int categoryId);
    List<Blog> selectAll();
    Blog selectById(Integer blogId);
    List<Blog> selectByUser(Integer userId);
    //List<Blog> selectByStatus(Integer blogStatus);
    List<BlogSet> selectGroup();//this equal selectByStatus(2);
    List<BlogSet> selectByStatus(Integer status);
}
