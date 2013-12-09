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
 * RUN Luck Man * Job上下文 当存在多个Job顺序处理时，通过上下文莱传递Job状态与信息
 * 只有美才能，好用
 * @author qiaokai
 * @date 2013-12-3 16:20:04
 */
public class JobContext {
    /**
     * 返回job上下文   包括工作目录、运行级别、资源文件等
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
     * 定义运行级别
     */
    public static final int SCHEDULE_RUN = 1;
    public static final int MANUAL_RUN = 2;
    public static final int DEBUG_RUN = 3;

    private final int runType;
    /**
     * 数据缓冲区
    */
    private Map<String, Object> data=new HashMap<String, Object>();
    /**
     * 预先跳出 退出code
     */
    private Integer preExitCode;
	private Integer coreExitCode;
	//工作目录
	private String workDir;
    
    private List<Map<String, String>> resources;
    
    
    /**
     * 默认为手动执行的
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
