package com.thinkit.webservice;

import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.thinkit.pojo.AnaParams;
import com.thinkit.pojo.SpeechPojo;
@WebService
public interface Speech2Text {
		//����¼��ת��ӿ�
		//List< ResultPojo > speech2Text (List< SpeechPojo > speechList);
		//¼��ת��ӿ�
		void speech2Text (String voiceFilePath, String resultFilePath, String   grammarFilePath,AnaParams params,List< SpeechPojo> speechList);
		
		//	������ʷ�¼��λ�ȡ�Ѿ�ת��¼����ˮ�ӿ�
		List<String> getSpeechIds (Date startTime, Date endTime);
		
		
		//void TestPerl();
		
	//	void TestShell();
		
}
