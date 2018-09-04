package cn.nnu.jyjs.etpweb.bean;

import java.util.Date;

public class Blog {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer blogId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogTitle
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private String blogTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogStatus
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer blogStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogUpdateT
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.authorId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogAbstract
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private String blogAbstract;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogCTR
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer clickRate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogCalegory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer blogCalegory;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tblog.blogContent
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private String blogContent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogId
     *
     * @return the value of tblog.blogId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogId
     *
     * @param blogId the value for tblog.blogId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogTitle
     *
     * @return the value of tblog.blogTitle
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public String getBlogTitle() {
        return blogTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogTitle
     *
     * @param blogTitle the value for tblog.blogTitle
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogStatus
     *
     * @return the value of tblog.blogStatus
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getBlogStatus() {
        return blogStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogStatus
     *
     * @param blogStatus the value for tblog.blogStatus
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setBlogStatus(Integer blogStatus) {
        this.blogStatus = blogStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogUpdateT
     *
     * @return the value of tblog.blogUpdateT
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogUpdateT
     *
     * @param updateDate the value for tblog.blogUpdateT
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.authorId
     *
     * @return the value of tblog.authorId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.authorId
     *
     * @param authorId the value for tblog.authorId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogAbstract
     *
     * @return the value of tblog.blogAbstract
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public String getBlogAbstract() {
        return blogAbstract;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogAbstract
     *
     * @param blogAbstract the value for tblog.blogAbstract
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setBlogAbstract(String blogAbstract) {
        this.blogAbstract = blogAbstract == null ? null : blogAbstract.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogCTR
     *
     * @return the value of tblog.blogCTR
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getClickRate() {
        return clickRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogCTR
     *
     * @param clickRate the value for tblog.blogCTR
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogCalegory
     *
     * @return the value of tblog.blogCalegory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getBlogCalegory() {
        return blogCalegory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogCalegory
     *
     * @param blogCalegory the value for tblog.blogCalegory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setBlogCalegory(Integer blogCalegory) {
        this.blogCalegory = blogCalegory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tblog.blogContent
     *
     * @return the value of tblog.blogContent
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public String getBlogContent() {
        return blogContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tblog.blogContent
     *
     * @param blogContent the value for tblog.blogContent
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}