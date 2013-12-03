package com.thinkit.vo;

public class SpeechVo {
	
	private String speechId;
	private String xmlresult;
	private String status;
	private String insertTime;
	public String getSpeechId() {
		return speechId;
	}
	public void setSpeechId(String speechId) {
		this.speechId = speechId;
	}
	public String getXmlresult() {
		return xmlresult;
	}
	public void setXmlresult(String xmlresult) {
		this.xmlresult = xmlresult;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	@Override
	public String toString() {
		return "SpeechVo [speechId=" + speechId + ", xmlresult=" + xmlresult
				+ ", status=" + status + ", insertTime=" + insertTime + "]";
	}
	
	
	
}
