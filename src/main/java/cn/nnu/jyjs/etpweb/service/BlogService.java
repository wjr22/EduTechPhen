package cn.nnu.jyjs.etpweb.service;

import cn.nnu.jyjs.etpweb.bean.Blog;

import java.util.List;

/**
 * @Project :   etpweb
 * @Time :   9/5/2018 22:15
 * @Auther :   wangj
 * @Description:
 */
public interface BlogService {
    int insertBlog(Blog record,int userId,int categoryId);
    List<Blog> selectByCategory(int categoryId);
    List<Blog> selectAll();
}
