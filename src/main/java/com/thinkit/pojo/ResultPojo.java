package com.thinkit.pojo;

import java.util.Date;

/**
 * 
 * @author Administrator
 * ת��������
 */
public class ResultPojo extends BasePojo {

	private static final long serialVersionUID = 1L;
	
	private  String   speechId ;
	//��ϯ�ı�
	private String   agentContent ;
	// ��ϯ�����ı���Ӧʱ���
	private  String   agentContentTime;
	//�ͻ������ı�
	private  String   customerText ;
	//�ͻ������ı���Ӧʱ���
	private String   customerTextTime;
	//���������ı� ����ϣ�
	private String   conversationText;
	//���������ı���Ӧʱ���  �ô����ĵ���һ��
	private   String   conversationTime;
	//����ִ�н����1������ɹ��� 2������ʧ��
	private String excResult;
	//ǿ�廰ʱ��
	private String  agentInterruptionTime;  
	//��ϯ������⣨2000 4000��9000 12000����������
	private  String   agentLongSilence;
	//�ͻ�������⣨2000 4000��9000 12000����������
	private String   customerLongSilence;
	//��ϯ������⣨ANGRY 2000 4000 0.15��ANGRY 9000 12000 0.06���������� 
	private String   agentEmotion;
	// �ͻ�������⣨ANGRY 2000 4000 0.15��ANGRY 9000 12000 0.06����������
	private    String   customerEmotion;
	// ��ϯ����
	private String   agentSpeed;
	//�ͻ�����
	private String   customerSpeed;
	//��ϯ�ؼ��� ��ʲô�� 1000 2000����ô˵���� 3000 4000����������
	private String   agentKeyWords;
	//�ͻ��ؼ��� ��ʲô�� 1000 2000 100����ô˵���� 3000 4000 150����������
	private String   customerKeyWords ;
	//���뿪ʼʱ��
	private Date    analStartTime ; 
	//�������ʱ��
	private Date    analEndTime;    
	//��������ʱ��
	private int      analysisTime;   
	//Ԥ���ֶ�(Ԥ��)
	private String   dyfield01;   
	//Ԥ���ֶ�
	private String   dyfield02;   
	//Ԥ���ֶ�
	private String   dyfield03;   
	//Ԥ���ֶ�
	private String   dyfield04;   
	//Ԥ���ֶ�
	private String   dyfield05;   
	//���ת��ɹ�Ϊtrue������Ϊfalse
	private  Boolean  successful;  
	//���ת��ʧ�ܣ������԰����쳣��Ϣ
	private String   resDesc;
	
	public String getSpeechId() {
		return speechId;
	}
	public void setSpeechId(String speechId) {
		this.speechId = speechId;
	}
	public String getAgentContent() {
		return agentContent;
	}
	public void setAgentContent(String agentContent) {
		this.agentContent = agentContent;
	}
	public String getAgentContentTime() {
		return agentContentTime;
	}
	public void setAgentContentTime(String agentContentTime) {
		this.agentContentTime = agentContentTime;
	}
	public String getCustomerText() {
		return customerText;
	}
	public void setCustomerText(String customerText) {
		this.customerText = customerText;
	}
	public String getCustomerTextTime() {
		return customerTextTime;
	}
	public void setCustomerTextTime(String customerTextTime) {
		this.customerTextTime = customerTextTime;
	}
	public String getConversationText() {
		return conversationText;
	}
	public void setConversationText(String conversationText) {
		this.conversationText = conversationText;
	}
	public String getConversationTime() {
		return conversationTime;
	}
	public void setConversationTime(String conversationTime) {
		this.conversationTime = conversationTime;
	}
	public String getExcResult() {
		return excResult;
	}
	public void setExcResult(String excResult) {
		this.excResult = excResult;
	}
	public String getAgentInterruptionTime() {
		return agentInterruptionTime;
	}
	public void setAgentInterruptionTime(String agentInterruptionTime) {
		this.agentInterruptionTime = agentInterruptionTime;
	}
	public String getAgentLongSilence() {
		return agentLongSilence;
	}
	public void setAgentLongSilence(String agentLongSilence) {
		this.agentLongSilence = agentLongSilence;
	}
	public String getCustomerLongSilence() {
		return customerLongSilence;
	}
	public void setCustomerLongSilence(String customerLongSilence) {
		this.customerLongSilence = customerLongSilence;
	}
	public String getAgentEmotion() {
		return agentEmotion;
	}
	public void setAgentEmotion(String agentEmotion) {
		this.agentEmotion = agentEmotion;
	}
	public String getCustomerEmotion() {
		return customerEmotion;
	}
	public void setCustomerEmotion(String customerEmotion) {
		this.customerEmotion = customerEmotion;
	}
	public String getAgentSpeed() {
		return agentSpeed;
	}
	public void setAgentSpeed(String agentSpeed) {
		this.agentSpeed = agentSpeed;
	}
	public String getCustomerSpeed() {
		return customerSpeed;
	}
	public void setCustomerSpeed(String customerSpeed) {
		this.customerSpeed = customerSpeed;
	}
	public String getAgentKeyWords() {
		return agentKeyWords;
	}
	public void setAgentKeyWords(String agentKeyWords) {
		this.agentKeyWords = agentKeyWords;
	}
	public String getCustomerKeyWords() {
		return customerKeyWords;
	}
	public void setCustomerKeyWords(String customerKeyWords) {
		this.customerKeyWords = customerKeyWords;
	}
	public Date getAnalStartTime() {
		return analStartTime;
	}
	public void setAnalStartTime(Date analStartTime) {
		this.analStartTime = analStartTime;
	}
	public Date getAnalEndTime() {
		return analEndTime;
	}
	public void setAnalEndTime(Date analEndTime) {
		this.analEndTime = analEndTime;
	}
	public int getAnalysisTime() {
		return analysisTime;
	}
	public void setAnalysisTime(int analysisTime) {
		this.analysisTime = analysisTime;
	}
	public String getDyfield01() {
		return dyfield01;
	}
	public void setDyfield01(String dyfield01) {
		this.dyfield01 = dyfield01;
	}
	public String getDyfield02() {
		return dyfield02;
	}
	public void setDyfield02(String dyfield02) {
		this.dyfield02 = dyfield02;
	}
	public String getDyfield03() {
		return dyfield03;
	}
	public void setDyfield03(String dyfield03) {
		this.dyfield03 = dyfield03;
	}
	public String getDyfield04() {
		return dyfield04;
	}
	public void setDyfield04(String dyfield04) {
		this.dyfield04 = dyfield04;
	}
	public String getDyfield05() {
		return dyfield05;
	}
	public void setDyfield05(String dyfield05) {
		this.dyfield05 = dyfield05;
	}
	public Boolean getSuccessful() {
		return successful;
	}
	public void setSuccessful(Boolean successful) {
		this.successful = successful;
	}
	public String getResDesc() {
		return resDesc;
	}
	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}  
	
	

}
