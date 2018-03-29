package com.boxu.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
	@RequestMapping("goto_login")
	public String goto_login() {
		return "login";
	}
	@RequestMapping("goto_regist")
	public String goto_regist() {
		return "regist";
	}
	@RequestMapping("goto_user")
	public String goto_user() {
		return "user/user";
	}
	@RequestMapping("goto_manager")
	public String goto_manager() {
		return "manager";
	}
	@RequestMapping("loginout")
	public String loginout() {
		return "index";
	}
	@RequestMapping("user_info")
	public String user_info() {
		return "user/user_info";
	}
	
	
	
}
