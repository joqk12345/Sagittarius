package com.thinkit.pojo;

/**
 * 
 * @author Administrator
 *  ¼������
 */
public class SpeechPojo extends BasePojo{
	
	
	private static final long serialVersionUID = 1L;
	//������ˮid
	private String   speechId;
	//����ת��·��
	private String   filePath;
	//������������  0��ʾ���롢1��ʾ����
	private String   callType;
	
	
	public String getSpeechId() {
		return speechId;
	}
	public void setSpeechId(String speechId) {
		this.speechId = speechId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getCallType() {
		return callType;
	}
	public void setCallType(String callType) {
		this.callType = callType;
	}
	
	

}
