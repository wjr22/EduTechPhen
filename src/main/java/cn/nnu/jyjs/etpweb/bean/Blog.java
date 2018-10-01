package cn.nnu.jyjs.etpweb.bean;

import java.util.Date;

public class Blog {

    private Integer blogId;

    private String blogTitle;

    private Integer blogStatus;

    private Date updateDate;

    private Integer authorId;

    private String blogAbstract;

    private Integer clickRate;

    private Integer blogCategory;

    private String blogContent;

    private String author;

    private String category;

    private Date createDate;

    public Blog(){

    }

    /**
     *
     * @param title
     * @param content
     * @param category
     */
    public Blog(String title,String content,int category){
        this.blogTitle = title;
        this.blogContent = content;
        this.blogCategory = category;
        Date date = new Date();
        this.updateDate = date;
    }

    /**
     *
     * @param title
     * @param content
     * @param category
     * @param blogAbstract
     */
    public Blog(String title,String content,int category,String blogAbstract){
        this.blogCategory = category;
        this.blogContent = content;
        this.blogTitle = title;
        this.blogAbstract = blogAbstract;
    }

    /**
     *
     * @param title
     * @param content
     * @param blogAbstract
     */
    public Blog(String title,String content,String blogAbstract){
        this.blogContent = content;
        this.blogTitle = title;
        this.blogAbstract = blogAbstract;
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
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Integer getBlogStatus() {
        return blogStatus;
    }

    public void setBlogStatus(Integer blogStatus) {
        this.blogStatus = blogStatus;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getBlogAbstract() {
        return blogAbstract;
    }

    public void setBlogAbstract(String blogAbstract) {
        this.blogAbstract = blogAbstract == null ? null : blogAbstract.trim();
    }


    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    public Integer getBlogCategory() {
        return blogCategory;
    }

    public void setBlogCategory(Integer blogCategory) {
        this.blogCategory = blogCategory;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getClickRate() {
        return clickRate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}