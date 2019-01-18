package cn.nnu.jyjs.etpweb.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Comment {

    private Long commentId;

    private String userName;

    private Integer blogId;

    private Integer userId;

    private String content;

    @JSONField(format="yyyy-MM-dd HH:mm")        //转为JSON时按格式转换
    private Date createT;

    private Long parentId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateT() {
        return createT;
    }

    public void setCreateT(Date createT) {
        this.createT = createT;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}