package com.boxu.contoller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boxu.bean.Model_sun_down_time;
import com.boxu.bean.Model_time_etc;
import com.boxu.bean.Sun_down_time;
import com.boxu.bean.Time_etc;
import com.boxu.service.TimeService;

@Controller
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	
	/**
	 * 时段-亮度对象的添加
	 * @param model_time_etc
	 * @param user_id
	 * @return
	 */
	@RequestMapping("set_time_etc")
	private String set_time_etc(Model_time_etc model_time_etc,int user_id) {
		Time_etc time_etc = get_time_etc(model_time_etc,user_id);
		timeService.set_time_etc(time_etc);
		return "time_etc/set_time_etc_list";
	}
    
	/**
	 * 根据模型类和用户id,获得时段-亮度的对象
	 * @param model_time_etc
	 * @param user_id
	 * @return
	 */
	private Time_etc get_time_etc(Model_time_etc model_time_etc,int user_id) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date start_t = new Date();
		start_t.setHours(model_time_etc.getStart_h());
		start_t.setMinutes(model_time_etc.getStart_m());
		start_t.setSeconds(model_time_etc.getStart_s());
		String format_start_t = format.format(start_t);
		Date end_t = new Date();
		end_t.setHours(model_time_etc.getEnd_h());
		end_t.setMinutes(model_time_etc.getEnd_m());
		end_t.setSeconds(model_time_etc.getEnd_s());
		String format_end_t = format.format(end_t);
		Time_etc time_etc = new Time_etc();
		time_etc.setStart_t(format_start_t);
		time_etc.setEnd_t(format_end_t);
		time_etc.setUser_id(user_id);
		time_etc.setEtc(model_time_etc.getBright());
		return time_etc;
	}
	
	/**
	 * 回显时段-亮度列表
	 * 异步请求
	 * 返回的是一个页面对象，直接嵌入到列表页中
	 * @param map
	 * @param user_id
	 * @return
	 */
	@RequestMapping("goto_set_time_etc_list")
	public String goto_set_time_etc_list(ModelMap map,int user_id) {
		List<Time_etc> time_etc_list = timeService.get_time_etc_list(user_id);
		map.put("time_etc_list", time_etc_list);
		return "time_etc/etc_list";
	}
	
	/**
	 * 跳转到时段-亮度的显示页面
	 * @return
	 */
	@RequestMapping("goto_set_time_etc_list_page")
	public String goto_set_time_etc_list_page() {
		return "time_etc/set_time_etc_list";
	}
	
	/**
	 * 跳转到时段-亮度的添加页面
	 * @return
	 */
	@RequestMapping("goto_set_time_etc")
	public String goto_set_time_etc() {
		return "time_etc/add_time_etc";
	}
	
	/**
	 * 删除一条时段-亮度设置
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("delete_time_etc")
	public String delete_time_etc(int id) {
		timeService.delete_time_etc(id);
		return "";
	}
	/**
	 * 跳转到时段-亮度的修改页面
	 * 回显修改前的时间
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping("goto_edit_time_etc_page")
	public String goto_edit_time_etc_page(int id,ModelMap map) {
		Time_etc time_etc = timeService.get_time_etc_by_id(id);
		Model_time_etc model_time_etc = get_model_time_etc(time_etc);
		map.put("model_time_etc", model_time_etc);
		map.put("id", id);
		return "time_etc/edit_time_etc";
	}

	/**
	 * 数据库的时段-亮度对象转换为模型对象的方法
	 * @param time_etc
	 * @return
	 */
	private Model_time_etc get_model_time_etc(Time_etc time_etc) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Model_time_etc model_time_etc = new Model_time_etc();
		String start_t = time_etc.getStart_t();
		Date parse = null;
		try {
			parse = format.parse(start_t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model_time_etc.setStart_h(parse.getHours());
		model_time_etc.setStart_m(parse.getMinutes());
		model_time_etc.setStart_s(parse.getSeconds());
		String end_t = time_etc.getEnd_t();
		Date parse2 =null;
		try {
			parse2 = format.parse(end_t);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model_time_etc.setEnd_h(parse2.getHours());
		model_time_etc.setEnd_m(parse2.getMinutes());
		model_time_etc.setEnd_s(parse2.getSeconds());
		model_time_etc.setBright(time_etc.getEtc());
		return model_time_etc;
	}
	
	/**
	 * 分时段设置亮度的修改
	 * 修改后跳转到时间设置列表页面
	 * @param model_time_etc
	 * @param user_id
	 * @param id
	 * @return
	 */
	@RequestMapping("edit_time_etc")
	private String edit_time_etc(Model_time_etc model_time_etc,int user_id,int id) {
		Time_etc time_etc = get_time_etc(model_time_etc,user_id);
		time_etc.setId(id);
		timeService.edit_time_etc(time_etc);
		return "time_etc/set_time_etc_list";
	}
	/**
	 * 跳转到设置落日时间页面
	 * @return
	 */
	@RequestMapping("goto_set_time")
	public String goto_set_time() {
		return "time_etc/sun_down_time";
	}
	/**
	 * 首次设置添加落日时间
	 * 再次设置修改落日时间
	 * 完成后重定向到设置落日时间页面
	 * @param time
	 * @param user_id
	 * @return
	 */
	@RequestMapping("set_time")
	public String set_time(Model_sun_down_time time,int user_id) {
		Sun_down_time db_sun_down_time = timeService.query_sun_down_time_by_user_id(user_id);
		Sun_down_time sun_down_time = time_to_date(time,user_id);
		if(db_sun_down_time==null) {
			timeService.add_sun_down_time(sun_down_time);
		}else {
			timeService.update_sun_down_time(sun_down_time);
		}
		return "redirect:/goto_set_time.do";
	}
    /**
     * 根据模型类与用户id生成落日时间对象的方法
     * @param time
     * @param user_id
     * @return
     */
	private Sun_down_time time_to_date(Model_sun_down_time time,int user_id) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date();
		date.setHours(time.getH());
		date.setMinutes(time.getM());
		date.setSeconds(time.getS());
		String string = format.format(date);
		Sun_down_time sun_down_time = new Sun_down_time();
		sun_down_time.setSun_down_time(string);
		sun_down_time.setUser_id(user_id);
		return sun_down_time;
	}
	
	/**
	 * 跳转到落日时间页面，回显之前设置时间的异步请求
	 * 没有则不显示
	 * @param user_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("show_sun_down_time")
	public Model_sun_down_time show_sun_down_time(int user_id) {
		Sun_down_time db_sun_down_time = timeService.query_sun_down_time_by_user_id(user_id);
		if(db_sun_down_time!=null) {
			Model_sun_down_time model = time_to_model(db_sun_down_time);
			return model;
		}
		return null;
	}

	/**
	 * 数据库的落日时间对象，转换为模型对象的方法
	 * @param db_sun_down_time
	 * @return
	 */
	private Model_sun_down_time time_to_model(Sun_down_time db_sun_down_time) {
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Model_sun_down_time model_sun_down_time = null;
		try {
			Date parse = format.parse(db_sun_down_time.getSun_down_time());
			model_sun_down_time = new Model_sun_down_time();
			model_sun_down_time.setH(parse.getHours());
			model_sun_down_time.setM(parse.getMinutes());
			model_sun_down_time.setS(parse.getSeconds());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return model_sun_down_time;
	}

}
