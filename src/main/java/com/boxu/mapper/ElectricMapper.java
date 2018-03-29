package com.boxu.mapper;

import com.boxu.bean.Electric;

public interface ElectricMapper {

	void edit_overcurrent_protection(Electric ele);

	void add_overcurrent_protection(Electric ele);

	Electric query_overcurrent_protection(int user_id);

}
