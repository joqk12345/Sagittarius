package com.thinkit.webservice;

import java.util.Date;
import java.util.List;

import com.thinkit.pojo.ResultPojo;
import com.thinkit.pojo.SpeechPojo;
/**
 * 
 * @author Administrator
 * ����ת��ӿڸ��������ϵͳ��ת��
 */
public interface Speech2Text1 {

	//��������ת��
	ResultPojo speech2Text (SpeechPojo speech);
	//����¼��ת��ӿ�
	List< ResultPojo > speech2Text (List< SpeechPojo > speechList);
	//	������ʷ�¼��λ�ȡ�Ѿ�ת��¼����ˮ�ӿ�
	List<String> getSpeechIds (Date startTime, Date endTime);
	
}
