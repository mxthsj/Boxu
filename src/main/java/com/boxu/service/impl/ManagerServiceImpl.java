package com.boxu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxu.bean.Manager;
import com.boxu.mapper.ManagerMapper;
import com.boxu.service.ManagerService;
import com.boxu.util.MD5Util;
@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerMapper managerMapper;

	@Override
	public Manager queryManagerByLogin(String username) {
		Manager manager = managerMapper.queryManagerByLogin(username);
		return manager;
	}

	@Override
	public int addManagerByRegist(Manager manager) {
		String password = manager.getPassword();
		String digest = MD5Util.digest(password);
		manager.setPassword(digest);
		int i = managerMapper.addManagerByRegist(manager);
		return i;
	}

}
