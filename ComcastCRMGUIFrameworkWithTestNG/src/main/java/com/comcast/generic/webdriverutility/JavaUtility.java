package com.comcast.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomNumber=random.nextInt(5000);
		return randomNumber;
	}
	
	public StringBuilder getAlphanumericRandomNumber() {
		int n=20;
		String AlphNumericString="ABCDREFGJJUH1234566asvhnjnjj";
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<=n;i++)
		{
			int index=(int) (AlphNumericString.length()*Math.random());
			sb.append(AlphNumericString.charAt(index));
		}
		return sb;
	}
	
	public String getSystemDateYYYDDMM() {
		Date dateobj= new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date=sim.format(dateobj);
		return date;
		
	}
	
	public String  getRequiredDateYYYYDDMM(int days)
	{
		Date dateobj= new Date();
	    SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	    String date=sim.format(dateobj);
	    
	    Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sim.format(cal.getTime());
		
		return reqDate;
		
	}
	
	

}
