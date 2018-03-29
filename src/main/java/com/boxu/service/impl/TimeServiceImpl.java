package com.boxu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxu.bean.Sun_down_time;
import com.boxu.bean.Time_etc;
import com.boxu.mapper.TimeMapper;
import com.boxu.service.TimeService;

@Service
public class TimeServiceImpl implements TimeService{

	@Autowired
	private TimeMapper timeMapper;
	
	@Override
	public void set_time_etc(Time_etc time_etc) {
		timeMapper.set_time_etc(time_etc);
	}

	@Override
	public List<Time_etc> get_time_etc_list(int user_id) {
		return timeMapper.get_time_etc_list(user_id);
	}

	@Override
	public void delete_time_etc(int id) {
		timeMapper.delete_time_etc(id);
	}

	@Override
	public Time_etc get_time_etc_by_id(int id) {
		return timeMapper.get_time_etc_by_id(id);
	}

	@Override
	public void edit_time_etc(Time_etc time_etc) {
		timeMapper.edit_time_etc(time_etc);
		
	}

	@Override
	public void add_sun_down_time(Sun_down_time sun_down_time) {
		timeMapper.add_sun_down_time(sun_down_time);
		
	}

	@Override
	public Sun_down_time query_sun_down_time_by_user_id(int user_id) {
		return timeMapper.query_sun_down_time_by_user_id(user_id);
	}

	@Override
	public void update_sun_down_time(Sun_down_time sun_down_time) {
		timeMapper.update_sun_down_time(sun_down_time);
		
	}

}
