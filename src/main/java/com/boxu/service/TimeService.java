package com.boxu.service;

import java.util.List;

import com.boxu.bean.Sun_down_time;
import com.boxu.bean.Time_etc;

public interface TimeService {

	void set_time_etc(Time_etc time_etc);

	List<Time_etc> get_time_etc_list(int user_id);

	void delete_time_etc(int id);

	Time_etc get_time_etc_by_id(int id);

	void edit_time_etc(Time_etc time_etc);

	void add_sun_down_time(Sun_down_time sun_down_time);

	Sun_down_time query_sun_down_time_by_user_id(int user_id);

	void update_sun_down_time(Sun_down_time sun_down_time);

}
