package com.shiro.dao;

import com.shiro.bean.Test;
import org.springframework.stereotype.Repository;

/**
 *@author  测试类接口
 */
@Repository("TestMapper")
public interface TestMapper {
    /**
     * 根据id删除信息
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 所以字段必须都要插入
     * @param record
     * @return
     */
    int insert(Test record);

    /**
     * 可以只插入需要的字段
     * @param record
     * @return
     */
    int insertSelective(Test record);

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    Test selectByPrimaryKey(Integer id);

    /**
     *修改信息要修改的字段可以任意
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Test record);

    /**
    * @Author liufei 
    * @Description 
    * @Date 11:37 2018/11/30
    * @Param [record]
    * @return int
    **/
    
    
	int updateByPrimaryKey(Test record);
}