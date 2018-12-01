package com.shiro.service.impl;

import com.shiro.bean.Function;
import com.shiro.service.FunctionService;
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
 * @ClassName: FunctionServiceImplTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:32
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class FunctionServiceImplTest {
	@Autowired
	private FunctionService service;
	@Test
	public void selectFunctionByUsername() {
		List<Function>list=service.selectFunctionByUsername("admin");
		for (Function function : list) {
			System.out.println(function);
		}
	}
}