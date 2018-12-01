package com.shiro.shiro;

import com.shiro.bean.Function;
import com.shiro.bean.Role;
import com.shiro.bean.User;
import com.shiro.dao.RoleMapper;
import com.shiro.service.FunctionService;
import com.shiro.service.RoleService;
import com.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: ssm_shiro_demo
 * @Package: com.shiro.shiro
 * @ClassName: MyRealm
 * @Author: liufei
 * @Description: 我的realm
 * @Date: 2018/11/30 15:39
 * @Version: 1.0
 */
public class MyRealm extends AuthorizingRealm {
	/**
	* @Author LiuFei
	* @Description session_key
	* @Date 11:06 2018/12/1
	* @Param
	* @return
	**/
	public static final String SESSION_USER_KEY = "user";

	@Autowired
	private RoleService roleService;


	@Autowired
	private UserService userService;


	@Autowired
	private FunctionService functionService;

	@Override
	public void setName(String name) {
		super.setName("MyRealm");
	}

	/**
	* @Author LiuFei
	* @Description 用来为当前登陆成功的用户授予权限和角色（已经登陆成功了）
	* @Date 18:06 2018/11/30
	* @Param [principalCollection]
	* @return org.apache.shiro.authz.AuthorizationInfo
	**/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//0.下面方法principals.getPrimaryPrincipal()获取的是在上面认证的时候装进AuthenticationInfo的对象
		User user = (User) principals.fromRealm(getName()).iterator().next();
		SimpleAuthorizationInfo simpleAuthorizationInfo=null;
		try {
			simpleAuthorizationInfo = new SimpleAuthorizationInfo();
			//1.设置所有的权限(注意权限是以字符串的形式保存的权限码)
			//获取所有权限码
			List<Function> permissions1 =functionService.selectFunctionByUsername(user.getUsername());
			Set<String> permissions = new HashSet<>();
			for(Function permission:permissions1){
				if(permission.getUrl().isEmpty()!=true){
					permissions.add(permission.getUrl());
				}
			}
			if (permissions != null && permissions.size()>0) {
				simpleAuthorizationInfo.setStringPermissions(permissions);
			}
			//2.设置角色，角色也是以字符串的形式表示(这里存的是角色名字)
			List<Role>roleList=roleService.selectRoleByUsername(user.getUsername());
			Set<String> userRoleNames =new HashSet<>();
			for (Role role : roleList) {
				if(role.getName().isEmpty()!=true){
					userRoleNames.add(role.getName());
				}
			}
			if(userRoleNames != null && userRoleNames.size()>0){
				simpleAuthorizationInfo.setRoles(userRoleNames);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return simpleAuthorizationInfo;
	}
	/**
	* @Author LiuFei
	* @Description 用来验证当前登录的用户，获取认证信息
	* @Date 18:06 2018/11/30
	* @Param [authenticationToken]
	* @return org.apache.shiro.authc.AuthenticationInfo
	**/
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		// 验证用户是否可以登录
		User user= userService.selectUserByUsername(username);
		if (user== null) {
			throw new UnknownAccountException("用户不存在");

		} else if (user.getState()==1) {
			throw new LockedAccountException("用户被锁定");
		}
		// 设置session
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute(MyRealm.SESSION_USER_KEY, user);
		// 以下信息从数据库中获取
		// 1 principal : 认证的实体信息，可以是username,也可以是数据表对应的实体对象。
		Object principal = username;
		// 3 realmName : 当前realm 对象的name ， 调用父类的 getName() 方法即可
		String realmName = getName();

		// 4.盐值
		ByteSource credentialsSalt = ByteSource.Util.bytes(username);
		// 这个是不加盐的 new SimpleAuthenticationInfo(principal, credentials,
		// realmName);
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,
				user.getPassword(), credentialsSalt, realmName);

		return info;
	}
	// 清除缓存
	public void clearCached() {
		PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
		super.clearCache(principals);
	}
}
