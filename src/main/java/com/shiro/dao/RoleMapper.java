package com.shiro.dao;

import com.shiro.bean.Role;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
* @Author LiuFei
* @Description 角色实体类
* @Date 16:52 2018/11/30
* @Param
* @return
**/
@Repository(value = "RoleMapper")
public interface RoleMapper {
	/**
	* @Author LiuFei
	* @Description  根据用户名查询所拥有的角色
	* @Date 17:02 2018/11/30
	* @Param [username]
	* @return java.util.List<com.shiro.bean.Role>
	**/
	List<Role>selectRoleByUsername(String username);
}