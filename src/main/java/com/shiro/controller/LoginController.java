package com.shiro.controller;

import com.shiro.bean.User;
import com.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.controller
 * @ClassName: LoginController
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2018/12/1 13:57
 * @Version: 1.0
 */
@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	private UserService service;


	@RequestMapping(value = "login")
	public String login(HttpServletRequest request){
		User user=new User();
		//获取账号
		String username=request.getParameter("name");
		//获取密码
		String password=request.getParameter("pass");
		user.setUsername(username);
		user.setPassword(password);
		UsernamePasswordToken token = new UsernamePasswordToken(
				user.getUsername(), user.getPassword());
		token.setRememberMe(true);

		// shiro登陆验证
		try {
			SecurityUtils.getSubject().login(token);
		} catch (UnknownAccountException ex) {
			System.out.println("用户不存在！");
			return "error";
		} catch (LockedAccountException ex) {
			System.out.println("用户锁定!");
			return "error";
		} catch (IncorrectCredentialsException ex) {
			System.out.println("用户名/密码验证失败!");
			return "error";
		} catch (Exception ex) {
			System.out.println("内部异常!");
			ex.printStackTrace();
			return "error";
		}
		return "success";
	}
}
