package com.boxu.contoller;

import javax.servlet.http.HttpSession;

import org.apache.cxf.binding.soap.interceptor.StartBodyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.boxu.bean.User_info;
import com.boxu.mapper.UserMapper;
import com.boxu.service.UserService;
import com.boxu.util.BaseController;
import com.boxu.util.UploadUtil;

@Controller
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	/**
	 * 文件上传400：
	 * java对象的里面的属性名和要上传的文件名重名了
	 * @param info
	 * @param imgd
	 * @return
	 */
	@RequestMapping("add_user_info")
	public String add_user_info(HttpSession se,User_info info,@RequestParam("imgd") MultipartFile imgd) {
		String img = UploadUtil.load(imgd);
		info.setImg(img);
		int user_id = (int) se.getAttribute("user_id");
		info.setUser_id(user_id);
		User_info db_info = userService.queryUserInfoByUserId(user_id);
		if(db_info==null) {
			userService.addUserInfo(info);
		}else {
			userService.editUserInfo(info);
		}
		return "redirect:/user_info.do";
	}
	
	@Autowired
	private UserMapper userMapper;
	
	@ResponseBody
	@RequestMapping("get_img")
	public Object get_img(HttpSession se) {
		start();
		int user_id = (int) se.getAttribute("user_id");
		User_info info = userMapper.queryUserInfoByUserId(user_id);
		data(info);
		success();
		return end();
	}

}
