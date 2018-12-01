package com.shiro.service.impl;

import com.shiro.bean.Function;
import com.shiro.dao.FunctionMapper;
import com.shiro.service.FunctionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.service.impl
 * @ClassName: FunctionServiceImpl
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/11/30 17:30
 * @Version: 1.0
 */
@Service(value = "FunctionServiceImpl")
public class FunctionServiceImpl implements FunctionService{
	@Resource
	private FunctionMapper dao;

	@Override
	public List<Function> selectFunctionByUsername(String username) {
		return dao.selectFunctionByUsername(username);
	}
}
