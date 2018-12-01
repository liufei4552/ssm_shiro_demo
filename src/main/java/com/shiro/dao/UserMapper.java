package com.shiro.dao;

import com.shiro.bean.User;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @Author LiuFei
* @Description
* @Date 17:12 2018/11/30
* @Param
* @return
**/
@Repository("UserMapper")
public interface UserMapper {
	/**
	* @Author LiuFei
	* @Description 根据用户名查询用户信息
	* @Date 17:13 2018/11/30
	* @Param [username]
	* @return com.shiro.bean.User
	**/
	User selectUserByUsername(String username);
	/**
	* @Author LiuFei
	* @Description  查询所有用户信息
	* @Date 16:57 2018/12/1
	* @Param []
	* @return java.util.List<com.shiro.bean.User>
	**/
	List<User>selectAllUser();
}