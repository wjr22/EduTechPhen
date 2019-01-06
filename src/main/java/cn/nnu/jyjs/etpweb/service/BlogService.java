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

    List<BlogSet> selectByCategory(String categoryId);
    List<BlogSet> selectAll();
    Blog selectById(Integer blogId);
    List<Blog> selectByUser(Integer userId);
    //List<Blog> selectByStatus(Integer blogStatus);
    List<BlogSet> selectGroup();//this equal selectByStatus(2);
    List<BlogSet> selectByStatus(Integer status);
    List<BlogSet> selectByUserId(Integer userId);

    BlogSet selectByBlogId(Integer blogId);

    int updateStatus(Blog blog);
}
