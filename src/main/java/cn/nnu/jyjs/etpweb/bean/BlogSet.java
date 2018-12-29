package cn.nnu.jyjs.etpweb.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Project :   etpweb
 * @Time :   11/10/2018 10:03
 * @Auther :   wangj
 * @Description:
 *      this bean is used for injecting to HTML,so it need union
 *      database relational table.
 */
public class BlogSet {
    private Integer blogId;

    private String blogTitle;

    private String blogStatus;

    @JSONField(format="yyyy-MM-dd HH:mm")        //转为JSON时按格式转换
    private Date updateDate;

    private String blogAbstract;

    private Integer clickRate;

    private String blogContent;

    private String author;

    private String category;

    public BlogSet(){
    }
    public BlogSet(Blog blog,String author,String category){
        this.author = author;
        this.category = category;
        this.blogTitle = blog.getBlogTitle();
        this.blogAbstract = blog.getBlogAbstract();
        this.blogContent = blog.getBlogContent();
        this.blogId = blog.getBlogId();
        this.clickRate = blog.getClickRate();
        this.updateDate = blog.getUpdateDate();
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(String blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getBlogAbstract() {
        return blogAbstract;
    }

    public void setBlogAbstract(String blogAbstract) {
        this.blogAbstract = blogAbstract;
    }

    public Integer getClickRate() {
        return clickRate;
    }

    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
