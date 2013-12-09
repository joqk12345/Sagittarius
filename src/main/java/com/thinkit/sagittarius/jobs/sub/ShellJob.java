package com.thinkit.sagittarius.jobs.sub;

import com.thinkit.sagittarius.jobs.JobContext;
import com.thinkit.sagittarius.jobs.ProcessJob;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/*
import org.apache.commons.io.IOUtils;
import com.taobao.zeus.jobs.JobContext;
import com.taobao.zeus.jobs.ProcessJob;
import com.taobao.zeus.util.PropertyKeys;
*/
/**
 *  ����Shell�ű�������
 * @author zhoufang
 *
 */
public class ShellJob extends ProcessJob{

	protected String shell;

	public ShellJob(JobContext jobContext) {
		super(jobContext);
	}
	public ShellJob(JobContext jobContext,String shell){
		this(jobContext);
		this.shell=shell;
	}
	
	@Override
	public Integer run() throws Exception {
		return super.run();
	}

	@Override
	public List<String> getCommandList() {
	
		List<String> list=new ArrayList<String>();
        
        //�л�Ŀ¼
        list.add("bash -c");
        list.add("cd /home/thinkit/huawei_test/");
        //�޸�Ȩ��
		list.add("chmod u+x hwrun.sh");
		//ת����ʽ
//		list.add("dos2unix " + shellFilePath);
		//ִ��shell
		list.add("sh hwrun.sh");
		return list;
	}
}
