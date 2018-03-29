package com.boxu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxu.bean.Electric;
import com.boxu.mapper.ElectricMapper;
import com.boxu.service.ElectricService;
@Service
public class ElectricServiceImpl implements ElectricService {
	
	@Autowired
	ElectricMapper electricMapper;

	@Override
	public void edit_overcurrent_protection(Electric ele) {
		electricMapper.edit_overcurrent_protection(ele);

	}

	@Override
	public Electric query_overcurrent_protection(int user_id) {
		
		return electricMapper.query_overcurrent_protection(user_id);
	}

}
