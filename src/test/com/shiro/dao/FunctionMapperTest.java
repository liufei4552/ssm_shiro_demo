package com.shiro.dao;

import com.shiro.bean.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.dao
 * @ClassName: FunctionMapperTest
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:46
 * @Version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application.xml"})
public class FunctionMapperTest {
	@Resource
	private FunctionMapper dao;
	@Test
	public void selectFunctionByUsername() {
		List<Function>list=dao.selectFunctionByUsername("admin");
		for (Function function : list) {
			System.out.println(function);
		}
	}
}