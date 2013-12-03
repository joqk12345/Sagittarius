package com.thinkit.webservice;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.thinkit.pojo.AnaParams;
import com.thinkit.pojo.SpeechPojo;
@WebService
public interface Speech2Text {
		//多条录音转译接口
		//List< ResultPojo > speech2Text (List< SpeechPojo > speechList);
		//录音转译接口
		void speech2Text (String voiceFilePath, String resultFilePath, String   grammarFilePath,AnaParams params,List< SpeechPojo> speechList);
		
		//	按照历史事件段获取已经转译录音流水接口
		List<String> getSpeechIds (Date startTime, Date endTime);
		
		
		//void TestPerl();
		
	//	void TestShell();
		
}
