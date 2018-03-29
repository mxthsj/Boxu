package com.boxu.service;

import com.boxu.bean.User;
import com.boxu.bean.User_info;

public interface UserService {

	User queryUserByLogin(String username);

	int addUserByRegist(User user);

	User_info queryUserInfoByUserId(int user_id);

	void addUserInfo(User_info info);

	void editUserInfo(User_info info);

}
