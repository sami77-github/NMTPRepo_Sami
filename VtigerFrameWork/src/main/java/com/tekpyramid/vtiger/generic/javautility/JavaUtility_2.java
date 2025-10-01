package com.tekpyramid.vtiger.generic.javautility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility_2 {

	// Random Number
     public int getRandomNumber() {
    	 Random random = new Random();
    	 int randomInt = random.nextInt(1000);
		return randomInt;
     }
     
     // Current system date
     public String getCurrentSystemDate() {
    	 Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
         String Date = sdf.format(date);
		return Date;
     }
     
    // End Date
     public String getRequiredDate() {
    	 Date date = new Date();
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = sdf.getCalendar();
        cal.add(Calendar.DAY_OF_MONTH, 30);
       String requiredDate = sdf.format(date);
	return requiredDate;
     }
}
