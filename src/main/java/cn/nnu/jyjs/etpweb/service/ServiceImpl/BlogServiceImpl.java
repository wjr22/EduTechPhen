package cn.nnu.jyjs.etpweb.service.ServiceImpl;

import cn.nnu.jyjs.etpweb.bean.Blog;
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
    public List<Blog> selectByCategory(int categoryId) {
        return blogMapper.selectByCategory(categoryId);
    }

    @Override
    public List<Blog> selectAll() {
        return blogMapper.selectAllPosts();
    }
}
