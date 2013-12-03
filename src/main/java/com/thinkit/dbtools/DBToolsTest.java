package com.thinkit.dbtools;

import java.util.ArrayList;
import java.util.Date;


//import org.junit.Before;
import org.junit.Test;

import com.thinkit.vo.SpeechVo;



public class DBToolsTest {
	

	@Test
	public void testInsertIdentifyInfo() {
		
		DateTools dt= new DateTools();
		SpeechVo spvo = new SpeechVo();
		spvo.setSpeechId("000879");
		spvo.setStatus("success");
		spvo.setXmlresult("<xml>xml info</xml>");
		spvo.setInsertTime(dt.ConvertDateToString(new Date()));
		System.out.println(spvo.toString());
		
		DBTools db = new DBTools();
		db.insertIdentifyInfo(spvo);
		
	}

	@Test
	public void testQueryIdentifyInfo() {
		DBTools db = new DBTools();
		DateTools dt= new DateTools();
		Date startT =dt.ConvertFormateStringToDate("2013-11-04 06:21:36");
		System.out.println("startT:"+startT);
		Date endT =dt.ConvertFormateStringToDate("2013-11-04 06:38:47");
		System.out.println("endT:"+endT);
		ArrayList<String> re = (ArrayList<String>) db.queryIdentifyInfo(startT, endT);
		for(String s:re){
			System.out.println("S:"+s);
		}
		System.out.println("size:"+db.queryIdentifyInfo(startT, endT).size());
		
	}

}
