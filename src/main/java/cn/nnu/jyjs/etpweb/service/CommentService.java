package cn.nnu.jyjs.etpweb.service;


import cn.nnu.jyjs.etpweb.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectByBlogId(Integer blogId);
    List<Comment> selectByUserId(Integer userId);
    List<Comment> selectByParent(Integer parentId);
}
