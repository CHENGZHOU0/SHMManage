package com.shm.test;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public class DateTest {
	public static void main(String args[]) {
		// ָ��ʱ�䴴������������Ϊ���꣬�£��գ�ʱ���֣��룬�·���Ҫ��һ
		Calendar calendar = new GregorianCalendar(2020, 0, 1, 0, 0, 0);
		
		Date time = calendar.getTime();
		System.out.println(time);
		
		//Dateת��ΪCalendar
		
//		calendar.setTime(current);
//		
//		calendar.add(Calendar.HOUR_OF_DAY, 1);
//		//Calendarת��ΪDate
//		Date date = calendar.getTime();
//		System.out.println(date);
		
		for (int i = 0; i < 100; i++) {
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			
			time = calendar.getTime();
			
			System.out.println(time);
		}
	}
}


