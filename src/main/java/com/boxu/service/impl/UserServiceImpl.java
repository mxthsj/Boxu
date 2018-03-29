package com.boxu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxu.bean.Electric;
import com.boxu.bean.User;
import com.boxu.bean.User_info;
import com.boxu.mapper.ElectricMapper;
import com.boxu.mapper.UserMapper;
import com.boxu.service.UserService;
import com.boxu.util.MD5Util;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	ElectricMapper electricMapper;


	@Override
	public User queryUserByLogin(String username) {
		User user = userMapper.queryUserByLogin(username);
		return user;
	}

	@Override
	public int addUserByRegist(User user) {
		String password = user.getPassword();
		String digest = MD5Util.digest(password);
		user.setPassword(digest);
		int i = userMapper.addUserByRegist(user);
		Electric ele = new Electric();
		ele.setUser_id(user.getId());
		ele.setOvercurrent_s(10);
		ele.setOvercurrent_e(30);
		electricMapper.add_overcurrent_protection(ele);
		return i;
	}

	@Override
	public User_info queryUserInfoByUserId(int user_id) {
		
		return userMapper.queryUserInfoByUserId(user_id);
	}

	@Override
	public void addUserInfo(User_info info) {
		
		userMapper.addUserInfo(info);
		
	}

	@Override
	public void editUserInfo(User_info info) {
		userMapper.editUserInfo(info);
		
	}

}
