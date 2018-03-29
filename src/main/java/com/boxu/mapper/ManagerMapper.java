package com.boxu.mapper;

import com.boxu.bean.Manager;

public interface ManagerMapper {

	Manager queryManagerByLogin(String username);

	int addManagerByRegist(Manager manager);

}
