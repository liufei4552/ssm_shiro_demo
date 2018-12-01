package com.shiro.service;

import com.shiro.bean.Role;

import java.util.List;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service
 * @ClassName: RoleService
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:27
 * @Version: 1.0
 */
public interface RoleService {
	/**
	 * @Author LiuFei
	 * @Description  根据用户名查询所拥有的角色
	 * @Date 17:02 2018/11/30
	 * @Param [username]
	 * @return java.util.List<com.shiro.bean.Role>
	 **/
	List<Role> selectRoleByUsername(String username);
}
