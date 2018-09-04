package cn.nnu.jyjs.etpweb.mapper;

import cn.nnu.jyjs.etpweb.bean.Blog;
import cn.nnu.jyjs.etpweb.bean.Example.BlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface BlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    long countByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int deleteByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int deleteByPrimaryKey(Integer blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int insert(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int insertSelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    List<Blog> selectByExampleWithBLOBs(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    List<Blog> selectByExample(BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    Blog selectByPrimaryKey(Integer blogId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByExample(@Param("record") Blog record, @Param("example") BlogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByPrimaryKeySelective(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(Blog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tblog
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByPrimaryKey(Blog record);
}