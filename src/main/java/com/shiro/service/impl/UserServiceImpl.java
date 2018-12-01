package com.shiro.service.impl;

import com.shiro.bean.User;
import com.shiro.dao.UserMapper;
import com.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service.impl
 * @ClassName: UserServiceImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:15
 * @Version: 1.0
 */
@Service(value = "UserServiceImpl")
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper dao;
	@Override
	public User selectUserByUsername(String username) {
		return dao.selectUserByUsername(username);
	}

	@Override
	public List<User> selectAllUser() {
		return dao.selectAllUser();
	}
}
