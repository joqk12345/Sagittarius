package com.thinkit.dbtools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTools {

	public static void main(String args[]){
		Date a =  new Date();
//		System.out.println(ConvertDateToString(a));
	}
	
	/**
	 *  将date类型转为string类型
	 * @param date
	 * @return
	 */
	public  String ConvertDateToString(Date date){
			String s;
			 java.text.DateFormat format1 = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
		        s = format1.format(date);  
		        System.out.println(s);
		        return s;
	}
	
	public Date ConvertFormateStringToDate(String dateString){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//小写的mm表示的是分钟  
		  
		java.util.Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return date;
	}
}
