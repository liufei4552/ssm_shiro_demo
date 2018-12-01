package com.shiro.service;

import com.shiro.bean.User;

import java.util.List;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service
 * @ClassName: UserService
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:14
 * @Version: 1.0
 */
public interface UserService {
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
	List<User> selectAllUser();
}
