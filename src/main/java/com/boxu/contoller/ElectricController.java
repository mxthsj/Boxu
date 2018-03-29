package com.boxu.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boxu.bean.Electric;
import com.boxu.service.ElectricService;

@Controller
public class ElectricController {
	
	@Autowired
	ElectricService electricService;
	
	@RequestMapping("goto_overcurrent_protection")
	public String goto_overcurrent_protection() {
		return "electric/overcurrent_protection";
	}
	
	@RequestMapping("edit_overcurrent_protection")
	public String edit_overcurrent_protection(Electric ele) {
		electricService.edit_overcurrent_protection(ele);
		return "redirect:/goto_overcurrent_protection.do";
	}
	
	@ResponseBody
	@RequestMapping("show_overcurrent_protection")
	public Electric show_overcurrent_protection(int user_id) {
		return electricService.query_overcurrent_protection(user_id);
	}

}
