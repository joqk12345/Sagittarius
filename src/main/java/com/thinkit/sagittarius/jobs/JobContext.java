/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thinkit.sagittarius.jobs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RUN Luck Man * Job������ �����ڶ��Job˳����ʱ��ͨ��������������Job״̬����Ϣ
 * ֻ�������ܣ�����
 * @author qiaokai
 * @date 2013-12-3 16:20:04
 */
public class JobContext {
    /**
     * ����job������   ��������Ŀ¼�����м�����Դ�ļ���
     * @return 
     */
    public static JobContext getTempJobContext(){
		JobContext jobContext=new JobContext();
//		JobHistory history=new JobHistory();
//		jobContext.setJobHistory(history);
		jobContext.setWorkDir("/tmp");
//		jobContext.setProperties(new HierarchyProperties(new HashMap<String, String>()));
		return jobContext;
	}
    
    /**
     * �������м���
     */
    public static final int SCHEDULE_RUN = 1;
    public static final int MANUAL_RUN = 2;
    public static final int DEBUG_RUN = 3;

    private final int runType;
    /**
     * ���ݻ�����
    */
    private Map<String, Object> data=new HashMap<String, Object>();
    /**
     * Ԥ������ �˳�code
     */
    private Integer preExitCode;
	private Integer coreExitCode;
	//����Ŀ¼
	private String workDir;
    
    private List<Map<String, String>> resources;
    
    
    /**
     * Ĭ��Ϊ�ֶ�ִ�е�
     */
    public JobContext() {
        this(MANUAL_RUN);
    }

    public JobContext(int runType) {
        this.runType = runType;
    }
    
    public Object getData(String key){
		return data.get(key);
	}
	public void putData(String key,Object d){
		data.put(key, d);
	}
	public Integer getPreExitCode() {
		return preExitCode;
	}
	public void setPreExitCode(Integer preExitCode) {
		this.preExitCode = preExitCode;
	}
	public Integer getCoreExitCode() {
		return coreExitCode;
	}
	public void setCoreExitCode(Integer coreExitCode) {
		this.coreExitCode = coreExitCode;
	}
	public String getWorkDir() {
		return workDir;
	}
	public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}
    public List<Map<String, String>> getResources() {
		return resources;
	}
	public void setResources(List<Map<String, String>> resources) {
		this.resources = resources;
	}
    
    public int getRunType() {
		return runType;
	}
    
}
