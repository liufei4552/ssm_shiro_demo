package com.shiro.service.impl;

import com.shiro.bean.Role;
import com.shiro.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service.impl
 * @ClassName: RoleServiceImplTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:33
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class RoleServiceImplTest {
	@Autowired
	private RoleService service;
	@Test
	public void selectRoleByUsername() {
		List<Role>list=service.selectRoleByUsername("admin");
		for (Role role : list) {
			System.out.println(role);
		}
	}
}