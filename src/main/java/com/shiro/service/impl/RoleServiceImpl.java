package com.shiro.service.impl;

import com.shiro.bean.Role;
import com.shiro.dao.RoleMapper;
import com.shiro.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service.impl
 * @ClassName: RoleServiceImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:28
 * @Version: 1.0
 */
@Service(value = "RoleServiceImpl")
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper dao;

	@Override
	public List<Role> selectRoleByUsername(String username) {
		return dao.selectRoleByUsername(username);
	}
}
