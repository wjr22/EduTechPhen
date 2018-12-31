package cn.nnu.jyjs.etpweb.service.ServiceImpl;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.BlogSet;
import cn.nnu.jyjs.etpweb.mapper.BlogMapper;
import cn.nnu.jyjs.etpweb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Project :   etpweb
 * @Time :   9/5/2018 22:16
 * @Auther :   wangj
 * @Description:
 */
@Service(value = "BlogService")
public class BlogServiceImpl implements BlogService {

    @Autowired(required = false)
    BlogMapper blogMapper;

    @Override
    public int insertBlog(Blog record,int userId,int categoryId) {
        record.setAuthorId(userId);
        record.setBlogCategory(categoryId);
        record.setClickRate(0);
        blogMapper.insertSelective(record);
        return 0;
    }

    @Override
    public int insert(Blog blog) {
        return blogMapper.insertSelective(blog);
    }

    @Override
    public List<Blog> selectByCategory(int categoryId) {
        return blogMapper.selectByCategory(categoryId);
    }

    @Override
    public List<BlogSet> selectAll() {
        return blogMapper.selectAllPosts();
    }

    @Override
    public Blog selectById(Integer blogId) {
        return blogMapper.selectByPrimaryKey(blogId);
    }

    @Override
    public List<Blog> selectByUser(Integer userId) {
        return blogMapper.selectByUser(userId);
    }

    //@Override
    //public List<Blog> selectByStatus(Integer blogStatus) {
    //    return blogMapper.selectByStatus(blogStatus);
    //}

    @Override
    public List<BlogSet> selectGroup() {
        return blogMapper.selectByVBlog();
    }

    @Override
    public List<BlogSet> selectByUserId(Integer userId) {
        return blogMapper.selectByUserIdSet(userId);
    }

    @Override
    public List<BlogSet> selectByStatus(Integer status) {
        return blogMapper.selectByStatus(status);
    }
}
