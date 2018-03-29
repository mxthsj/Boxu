package com.boxu.service;

import com.boxu.bean.Electric;

public interface ElectricService {

	void edit_overcurrent_protection(Electric ele);

	Electric query_overcurrent_protection(int user_id);

}
