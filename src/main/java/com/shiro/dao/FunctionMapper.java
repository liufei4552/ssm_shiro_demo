package com.shiro.dao;


import com.shiro.bean.Function;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
* @Author liufei
* @Description  权限实体类
* @Date 16:49 2018/11/30
* @Param
* @return
**/
@Repository(value = "FunctionMapper")
public interface FunctionMapper {
	/**
	* @Author LiuFei
	* @Description  根据用户名查询所拥有权限
	* @Date 16:48 2018/11/30
	* @Param [username]
	* @return java.util.List<com.shiro.bean.Function>
	**/
	List<Function>selectFunctionByUsername(String username);
}