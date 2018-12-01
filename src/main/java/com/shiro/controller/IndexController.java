package com.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.controller
 * @ClassName: indexController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/1 11:19
 * @Version: 1.0
 */
@Controller
@RequestMapping(value = "index")
public class IndexController {
	/**
	* @Author LiuFei
	* @Description 获取首页
	* @Date 11:22 2018/12/1
	* @Param []
	* @return java.lang.String
	**/
	@RequestMapping(value = "getIndex")
	public String getIndex(){
		return "index";
	}
}
