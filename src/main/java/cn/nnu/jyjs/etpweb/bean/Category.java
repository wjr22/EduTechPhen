package cn.nnu.jyjs.etpweb.bean;

public class Category {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcategory.categoryId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private Integer categoryId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tcategory.categoryName
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    private String categoryName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcategory.categoryId
     *
     * @return the value of tcategory.categoryId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcategory.categoryId
     *
     * @param categoryId the value for tcategory.categoryId
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tcategory.categoryName
     *
     * @return the value of tcategory.categoryName
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tcategory.categoryName
     *
     * @param categoryName the value for tcategory.categoryName
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
}