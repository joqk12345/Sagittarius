package com.thinkit.webservice;

import java.util.Date;
import java.util.List;

import com.thinkit.pojo.ResultPojo;
import com.thinkit.pojo.SpeechPojo;
/**
 * 
 * @author Administrator
 * 语音转义接口负责对语音系统的转义
 */
public interface Speech2Text1 {

	//单调语音转义
	ResultPojo speech2Text (SpeechPojo speech);
	//多条录音转译接口
	List< ResultPojo > speech2Text (List< SpeechPojo > speechList);
	//	按照历史事件段获取已经转译录音流水接口
	List<String> getSpeechIds (Date startTime, Date endTime);
	
}
