package com.shiro.service;

import com.shiro.bean.Function;

import java.util.List;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service
 * @ClassName: FunctionService
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:30
 * @Version: 1.0
 */
public interface FunctionService {
	/**
	 * @Author LiuFei
	 * @Description  根据用户名查询所拥有权限
	 * @Date 16:48 2018/11/30
	 * @Param [username]
	 * @return java.util.List<com.shiro.bean.Function>
	 **/
	List<Function> selectFunctionByUsername(String username);
}
