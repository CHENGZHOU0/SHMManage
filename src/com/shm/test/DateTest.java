package com.shm.test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class DateTest {
	public static void main(String args[]) {
		// 指定时间创建，参数依次为：年，月，日，时，分，秒，月份需要减一
		Calendar calendar = new GregorianCalendar(2020, 0, 1, 0, 0, 0);
		
		Date time = calendar.getTime();
		System.out.println(time);
		
		//Date转换为Calendar
		
//		calendar.setTime(current);
//		
//		calendar.add(Calendar.HOUR_OF_DAY, 1);
//		//Calendar转换为Date
//		Date date = calendar.getTime();
//		System.out.println(date);
		
		for (int i = 0; i < 100; i++) {
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			
			time = calendar.getTime();
			
			System.out.println(time);
		}
	}
}


