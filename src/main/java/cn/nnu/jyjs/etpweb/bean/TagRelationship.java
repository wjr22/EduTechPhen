package cn.nnu.jyjs.etpweb.bean;

public class TagRelationship {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ttagrelationship.tagId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer tagId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ttagrelationship.blogId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer blogId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ttagrelationship.tagId
     *
     * @return the value of ttagrelationship.tagId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ttagrelationship.tagId
     *
     * @param tagId the value for ttagrelationship.tagId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ttagrelationship.blogId
     *
     * @return the value of ttagrelationship.blogId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getBlogId() {
        return blogId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ttagrelationship.blogId
     *
     * @param blogId the value for ttagrelationship.blogId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }
}