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
	 *  ��date����תΪstring����
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//Сд��mm��ʾ���Ƿ���  
		  
		java.util.Date date = null;
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return date;
	}
}
