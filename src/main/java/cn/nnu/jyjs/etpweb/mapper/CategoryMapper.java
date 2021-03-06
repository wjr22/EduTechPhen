package cn.nnu.jyjs.etpweb.mapper;

import cn.nnu.jyjs.etpweb.bean.Category;
import cn.nnu.jyjs.etpweb.bean.Example.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    long countByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int deleteByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int insertSelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    List<Category> selectByExample(CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    Category selectByPrimaryKey(Integer categoryId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tcategory
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByPrimaryKey(Category record);

    Category selectByName(@Param("categoryName") String categoryName);
}