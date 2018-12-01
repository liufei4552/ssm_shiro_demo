package com.shiro.service.impl;

import com.shiro.bean.User;
import com.shiro.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service.impl
 * @ClassName: UserServiceImplTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:20
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class UserServiceImplTest {
	@Autowired
	private UserService service;
	@Test
	public void selectUserByUsername() {
		User user=service.selectUserByUsername("admin");
		System.out.println(user.getId());
		System.out.println(user.getPassword());
		System.out.println(user.getUsername());
		System.out.println(user.getState());
	}
}