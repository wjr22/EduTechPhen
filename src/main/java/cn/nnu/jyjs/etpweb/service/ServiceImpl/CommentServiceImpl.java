package cn.nnu.jyjs.etpweb.service.ServiceImpl;

import cn.nnu.jyjs.etpweb.bean.Comment;
import cn.nnu.jyjs.etpweb.mapper.CommentMapper;
import cn.nnu.jyjs.etpweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "CommentService")
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectByBlogId(Integer blogId) {
        return commentMapper.selectByBlogId(blogId);
    }

    @Override
    public List<Comment> selectByUserId(Integer userId) {
        return commentMapper.selectByUserId(userId);
    }

    @Override
    public List<Comment> selectByParent(Integer parentId) {
        return commentMapper.selectByParent(parentId);
    }
}
