package com.newPack;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Class_H {
	
	public static String getRequiredDateYYDDMM(int days) {
		  
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd");
		 Calendar cal=Calendar.getInstance();
		 cal.add(Calendar.DAY_OF_MONTH, days);
		 String reqDate=sdf.format(cal.getTime());
		 return reqDate;
	}
	
	public static int getRandomNumber() {
		Random random=new Random();
		int randomNumber=random.nextInt(5000);
		return randomNumber;
	}
	
	public static String getSystemDateYYYYDDMM() {
		Date dateObj=new Date ();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;
	}

	public static void main(String[] args) {
		System.out.println("Updated by Harshali");
		System.out.println("Updated by Harshali");	
		System.out.println("Updated by kaif ");
		System.out.println("hi");
		System.out.println("Updated second time by Harshali");
		System.out.println("Updated by Harshali");
		System.out.println("thursday");
		String day=Class_H.getRequiredDateYYDDMM(1);
		System.out.println(day);
		String date=Class_H.getSystemDateYYYYDDMM();
		System.out.println(date);
		
	}
}
