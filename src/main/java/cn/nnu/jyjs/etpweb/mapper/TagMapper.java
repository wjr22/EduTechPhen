package cn.nnu.jyjs.etpweb.mapper;

import cn.nnu.jyjs.etpweb.bean.Tag;
import cn.nnu.jyjs.etpweb.bean.Example.TagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    long countByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int deleteByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int deleteByPrimaryKey(Integer tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int insert(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int insertSelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    List<Tag> selectByExample(TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    Tag selectByPrimaryKey(Integer tagId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByExample(@Param("record") Tag record, @Param("example") TagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByPrimaryKeySelective(Tag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ttags
     *
     * @mbg.generated Sat Sep 01 15:46:56 CST 2018
     */
    int updateByPrimaryKey(Tag record);
}