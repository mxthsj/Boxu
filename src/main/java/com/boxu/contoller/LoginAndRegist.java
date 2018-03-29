package com.boxu.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boxu.bean.Manager;
import com.boxu.bean.User;
import com.boxu.service.ManagerService;
import com.boxu.service.UserService;
import com.boxu.util.BaseController;
import com.boxu.util.MD5Util;

@Controller
public class LoginAndRegist extends BaseController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private ManagerService managerService;
	//哈哈 just for fun
	@ResponseBody
	@RequestMapping("login")
	public Object login(HttpSession se,User user) {
		start();
		try {
			User db_user = userService.queryUserByLogin(user.getUsername());
			if(db_user!=null) {
				if(MD5Util.digest(user.getPassword()).equals(db_user.getPassword())) {
					se.setAttribute("login_name", user.getUsername());
					se.setAttribute("user_id", db_user.getId());
					success();
					msg("登录成功！");
					return end();
				}else {
					fail();
					msg("密码错误！");
				}
			}else {
				fail();
				msg("账户不存在！");
			}
		} catch (Exception e) {
			fail();
			msg("异常");
			e.printStackTrace();
		}
		return end();
	}
	
	@ResponseBody
	@RequestMapping("regist")
	public Object regist(User user) {
		start();
		try {
			User db_user = userService.queryUserByLogin(user.getUsername());
			if(db_user==null) {
				userService.addUserByRegist(user);
				success();
				msg("注册成功！");
				return end();
			}else {
				fail();
				msg("用户名已存在！");
			}
		} catch (Exception e) {
			fail();
			msg("异常");
			e.printStackTrace();
		}
		return end();
	}
	
	@RequestMapping("find_password")
	public String find_password() {
		return "find_password";
	}
	
	@ResponseBody
	@RequestMapping("manager_login")
	public Object manager_login(HttpSession se,Manager manager) {
		start();
		try {
			Manager db_manager = managerService.queryManagerByLogin(manager.getUsername());
			if(db_manager!=null) {
				if(MD5Util.digest(manager.getPassword()).equals(db_manager.getPassword())) {
					se.setAttribute("manager_login_name", manager.getUsername());
					success();
					msg("登录成功！");
					return end();
				}else {
					fail();
					msg("密码错误！");
				}
			}else {
				fail();
				msg("账户不存在！");
			}
		} catch (Exception e) {
			fail();
			msg("异常");
			e.printStackTrace();
		}
		return end();
	}
	
	
	@ResponseBody
	@RequestMapping("manager_regist")
	public Object manager_regist(Manager manager) {
		start();
		try {
			Manager db_manager = managerService.queryManagerByLogin(manager.getUsername());
			if(db_manager==null) {
				managerService.addManagerByRegist(manager);
				success();
				msg("注册成功！");
				return end();
			}else {
				fail();
				msg("用户名已存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			fail();
			msg("异常");
		}
		return end();
	}

}
