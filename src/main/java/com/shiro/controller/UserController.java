package com.shiro.controller;

import com.shiro.bean.User;
import com.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.controller
 * @ClassName: UserController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/1 16:58
 * @Version: 1.0
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService service;
	/**
	* @Author LiuFei
	* @Description  查询所有的用户
	* @Date 17:00 2018/12/1
	* @Param []
	* @return org.springframework.web.servlet.ModelAndView
	**/
	@RequestMapping("getAllUser")
	public ModelAndView getAllUser(){
		try {
			ModelMap model=new ModelMap();
			List<User>list=service.selectAllUser();
			if(list.size()>0){
				model.addAttribute("allUser", list);
			}
			return new ModelAndView("userlist",model);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
