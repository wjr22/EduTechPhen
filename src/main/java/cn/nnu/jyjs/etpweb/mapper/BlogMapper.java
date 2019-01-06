package cn.nnu.jyjs.etpweb.mapper;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.BlogSet;
import cn.nnu.jyjs.etpweb.bean.Example.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface BlogMapper {

    long countByExample(BlogExample example);

    int deleteByExample(BlogExample example);

    int deleteByPrimaryKey(Integer blogId);

    int insert(Blog record);

    int insertSelective(Blog record);

    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    List<Blog> selectByExample(BlogExample example);

    Blog selectByPrimaryKey(Integer blogId);

    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKeyWithBLOBs(Blog record);

    int updateByPrimaryKey(Blog record);

    //List<Blog> selectByCategory(Integer blogCategory);
    List<BlogSet> selectAllPosts();
    List<Blog> selectByUser(Integer userId);
    //List<Blog> selectByStatus(Integer blogStatus);
    List<BlogSet> selectByVBlog();
    List<BlogSet> selectByStatus(Integer status);

    List<BlogSet> selectByUserIdRetSet(Integer userId);

    BlogSet selectByBlogIdRetSet(Integer blogId);

    List<BlogSet> selectByCategory(String category);
}