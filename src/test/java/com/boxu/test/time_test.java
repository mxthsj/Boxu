package com.boxu.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class time_test {
	
	public static void main(String[] args) {
//		Date date = new Date();
//		date.setHours(5);
//		date.setMinutes(4);
//		date.setSeconds(2);
//		System.out.println(date);
		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
		Date date = new Date();
		date.setHours(1);
		date.setMinutes(2);
		date.setSeconds(3);
		String string = format.format(date);
		System.out.println(string);
	}

}
