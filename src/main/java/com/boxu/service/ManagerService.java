package com.boxu.service;

import com.boxu.bean.Manager;

public interface ManagerService {

	Manager queryManagerByLogin(String username);

	int addManagerByRegist(Manager manager);

}
