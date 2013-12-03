package com.thinkit.pojo;

/**
 * 
 * @author Administrator
 *  录音对象
 */
public class SpeechPojo extends BasePojo{
	
	
	private static final long serialVersionUID = 1L;
	//语音流水id
	private String   speechId;
	//语音转存路径
	private String   filePath;
	//语音呼叫类型  0表示呼入、1表示呼出
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
