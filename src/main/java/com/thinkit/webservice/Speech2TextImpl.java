package com.thinkit.webservice;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.thikit.util.FileUtil;
import com.thinkit.pojo.AnaParams;
import com.thinkit.pojo.SpeechPojo;
import java.util.logging.Level;

@WebService(endpointInterface = "com.thinkit.webservice.Speech2Text")
public class Speech2TextImpl implements Speech2Text {
	
	public static final String EVNPath = "/home/thinkit/huawei_test/";
	
	Logger logger = Logger.getLogger(Speech2TextImpl.class);
	
//	@Override
//	public void speech2Text(String voiceFilePath, String resultFilePath,String grammarFilePath, AnaParams params,List<SpeechPojo> speechList) {
//		String  listPath = "";
//		//1.1类型检查
//		if(null!=voiceFilePath||!"".equals(voiceFilePath)&&null!=resultFilePath||!"".equals(resultFilePath)&&speechList.size()>0){
//		//1.2转义list 形成list文件  和  下一步参数	
//			listPath = generateListFile(voiceFilePath.trim(),speechList);
//			//1.3执行shell命令完成操作  这一块先写死了  一次执行
//			if(!"".equals(listPath)){
//				
//				String cmd ="cd /home/thinkit/huawei_test/; sh hwrun.sh "+voiceFilePath+" "+resultFilePath+" "+listPath;
////				String cmd ="sh hwrun.sh "+voiceFilePath+" "+resultFilePath+" "+listPath;;
//                                logger.info("执行命令加上参数"+cmd);
//				this.runShell(cmd);
//			}
//		}
//	}
        @Override
	public void speech2Text(String voiceFilePath, String resultFilePath,String grammarFilePath, AnaParams params,List<SpeechPojo> speechList) {
            if(null!=voiceFilePath||!"".equals(voiceFilePath)&&null!=resultFilePath||!"".equals(resultFilePath)&&speechList.size()>0){
                int i=0;
                for(SpeechPojo pojo :speechList){
                    logger.info("第"+i+"条语音");
                    //执行单挑语音转义方法
                    speech2oneText(voiceFilePath,resultFilePath,pojo);
                }
            }
        }
        
	@Override
	public List<String> getSpeechIds(Date startTime, Date endTime) {
		return null;
	}
        //负责只执行单调语音
        private void speech2oneText(String voiceFilePath, String resultFilePath,SpeechPojo speechPo){
            String  pojoPath = "";
            if(null!=voiceFilePath||!"".equals(voiceFilePath)&&null!=resultFilePath||!"".equals(resultFilePath)){
                //1.将一条转换成一个文件
              pojoPath = generatePoJoFile( voiceFilePath,   speechPo);
                //2.执行shell命令
              if(!"".equals(pojoPath)){
				String cmd ="cd /home/thinkit/huawei_test/; sh hwrun.sh "+voiceFilePath+" "+resultFilePath+" "+pojoPath;
//				String cmd ="sh hwrun.sh "+voiceFilePath+" "+resultFilePath+" "+listPath;;
                                logger.info("执行命令加上参数"+cmd);
				this.runShell(cmd);
			}
            }
        }
        
        private void runShellTest2(String cmd){
        try {
            Process process1 = Runtime.getRuntime().exec("bash -c");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Speech2TextImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
			Process process1 = Runtime.getRuntime().exec("cd /home/thinkit/huawei_test");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
        
        try {
			Process process1 = Runtime.getRuntime().exec(cmd);
		} catch (IOException e3) {
			e3.printStackTrace();
		}
            
        }
        	
        
	private void runShellTest(String cmd){
		try{
			ProcessBuilder pb = new ProcessBuilder("bash", "-c");
			pb.redirectErrorStream(true); // use this to capture messages sent to stderr
			Process shell = pb.start();
			
			ProcessBuilder pb1 = new ProcessBuilder("cd", "/home/thinkit/huawei_test/");
			pb1.redirectErrorStream(true); // use this to capture messages sent to stderr
			Process shell1 = pb1.start();
			
			ProcessBuilder pb2 = new ProcessBuilder(cmd);
			pb2.redirectErrorStream(true); // use this to capture messages sent to stderr
			Process shell2 = pb2.start();
			
			logger.info("pb command "+pb.command());
			logger.info("pb command "+pb1.command());
			logger.info("pb command "+pb2.command());
			}
			catch (IOException ignoreMe)
			{
				ignoreMe.printStackTrace();
			}
	}
	
	private  void  runShell(String cmd){
		try{
//		String cmd1 = "cd /home/thinkit/huawei_test/"; // this is the command to execute in the Unix shell
//		String cmd1 ="cd /home/thinkit/huawei_test/; sh run.sh ";
		logger.info("the command "+cmd);
		// create a process for the shell
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
		pb.redirectErrorStream(true); // use this to capture messages sent to stderr
		Process shell = pb.start();
		InputStream shellIn = shell.getInputStream(); // this captures the output from the command
		int shellExitStatus = 0;
		try {
			shellExitStatus = shell.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // wait for the shell to finish and get the return code
//		
//		// at this point you can process the output issued by the command
//		// for instance, this reads the output and writes it to System.out:
//		int c;
//		while ((c = shellIn.read()) != -1) {
//			logger.info("shell read value:"+c);
//			}
//		// close the stream
//			shellIn.close();
//			logger.info(" *** End *** "+shellExitStatus);
//		
//		logger.info("pb command "+pb.command());
//		logger.info("pb command  dir  "+pb.directory());
//		logger.info(pb.environment());
//		logger.info(System.getenv());
//		logger.info(System.getProperties());
		}
		catch (IOException ignoreMe)
		{
			ignoreMe.printStackTrace();
		}
	}
        //针对单个pojo形成文件
        private  String  generatePoJoFile(String voiceFilePath,SpeechPojo speechPojo ){
		//目前只针对linux系统
		//存放list的文件
		logger.info(voiceFilePath+".list");
		String path =voiceFilePath+"/"+speechPojo.getSpeechId()+".list";
//		String path = "";
//		if(!"/".equals(voiceFilePath)){
//				path = voiceFilePath.substring(0,voiceFilePath.lastIndexOf("/"));	
//		}
		File file = new File(path);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			logger.info("create  file error");
			e.printStackTrace();
		}
		if(file.exists()){
			logger.info("the file create successful");
			StringBuffer resultBuffer = new StringBuffer();
                        if(!speechPojo.equals("")){
                            resultBuffer.append(voiceFilePath+"/"+speechPojo.getSpeechId()+"\n");
                            
                        }
			FileUtil fileUtile = new FileUtil();
			if(file.exists()){
				fileUtile.write(file, resultBuffer.toString());
			}
			logger.info("the create file path is :"+file.getAbsolutePath());
			return file.getAbsolutePath();
		}else{
			logger.info("the file create unsuccessful");
		}
		return null;
        }
	//针对list形成文件
	private  String  generateListFile(String voiceFilePath,List<SpeechPojo> speechList ){
		//目前只针对linux系统
		//存放list的文件
		logger.info(voiceFilePath+".list");
		String path =voiceFilePath+".list";
//		String path = "";
//		if(!"/".equals(voiceFilePath)){
//				path = voiceFilePath.substring(0,voiceFilePath.lastIndexOf("/"));	
//		}
		File file = new File(path);
		file.getParentFile().mkdirs();
		try {
			file.createNewFile();
		} catch (IOException e) {
			logger.info("create  file error");
			e.printStackTrace();
		}
		if(file.exists()){
			logger.info("the file create successful");
			StringBuffer resultBuffer = new StringBuffer();
			for(SpeechPojo sp :speechList){
				resultBuffer.append(voiceFilePath+"/"+sp.getSpeechId()+"\n");
			}
			FileUtil fileUtile = new FileUtil();
			if(file.exists()){
				fileUtile.write(file, resultBuffer.toString());
			}
			logger.info("the create file path is :"+file.getAbsolutePath());
			return file.getAbsolutePath();
		}else{
			logger.info("the file create unsuccessful");
		}
		return null;
	}
	/*
	@Override
	public void TestPerl() {
		try {
		File directory = new File(".");
		String dir1 = directory.getAbsolutePath();  
		logger.info("the current absolutePath "+ dir1);
		
//		String command1="bash -c cd /home/thinkit/huawei_test/";
		String[] command1 = new String[]{"bash", "-c ","cd /home/thinkit/huawei_test/"};
		try {
			Process process1 = Runtime.getRuntime().exec(command1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File directory2 = new File(".");
		String dir2 = directory2.getAbsolutePath();  
		logger.info("After  cd path the  current absolutePath "+ dir2);
		
		
		String separator = File.separator;
		logger.info("linux 系统的分隔符:"+separator);
		// create a new array of 2 strings
        String[] cmdArray = new String[9];

        // first argument is the program we want to open
        cmdArray[0] = "perl ";

        // second argument is a txt file we want to open with notepad
        cmdArray[1] = "run.pl";
        
        // third argument is a txt file we want to open with notepad
        cmdArray[2]="-v";
        
        cmdArray[3]="/home/thinkit/qiaokai/huawei/voice/v1";

     // fourth argument is a txt file we want to open with notepad
        cmdArray[4]="-r";
        
        cmdArray[5]="/home/thinkit/qiaokai/huawei/result/r1";
        
     // fifth argument is a txt file we want to open with notepad
        cmdArray[6]="-l";
        
        // six argument is a txt file we want to open with notepad
        cmdArray[7]="-t";
        
        cmdArray[8]="8";
        
        // create a file which contains the directory of the file needed
        File dir = new File(separator+"home"+separator+"thinkit"+separator+"huawei_test");
        if(dir.exists()){
        	logger.info("dir"+dir);
        }else{
        	logger.info("不存在目录：dir"+dir);
        }
        // create a process and execute cmdArray and currect environment
        Process process = Runtime.getRuntime().exec(cmdArray, null, dir);
        if(process.waitFor()>0){
        	  // print another message
        	logger.info("the command  execute successfully.");
        }else{
        	logger.info("the command  execute not successfully.");
        }
        
        
		 } catch (Exception ex) {
	         ex.printStackTrace();
	      }
		
		String command1="bash -c cd /home/thinkit/huawei_test/";
		try {
			Process process1 = Runtime.getRuntime().exec(command1);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String command2="bash -c perl /home/thinkit/huawei_test/run.pl -v /home/thinkit/qiaokai/huawei/voice/v1 -r /home/thinkit/qiaokai/huawei/result/r1 -l /home/thinkit/qiaokai/huawei/list/v3.list -t 8";
//		String command2="perl //home//thinkit//huawei_test//run.pl -v //home//thinkit//qiaokai//huawei//voice//v1 -r //home//thinkit//qiaokai//huawei//result//r1 -l //home//thinkit//qiaokai//huawei//list//v3.list -t 8";
		
		Process process2 = null;
		try {
			process2 = Runtime.getRuntime().exec(command2);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			//等待进程结束
			process2.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		}
	@Override
	public void TestShell() {
		try{
			File directory = new File(".");
			String dir1 = directory.getAbsolutePath();  
			logger.info("the current absolutePath "+ dir1);
			
		String cmd = "cd /home/thinkit/huawei_test/"; // this is the command to execute in the Unix shell
		cmd ="cd /home/thinkit/huawei_test/ ; sh run.sh";
		// create a process for the shell
		ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
		pb.redirectErrorStream(true); // use this to capture messages sent to stderr
		Process shell = pb.start();
		InputStream shellIn = shell.getInputStream(); // this captures the output from the command
		int shellExitStatus = 0;
		try {
			shellExitStatus = shell.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // wait for the shell to finish and get the return code
		// at this point you can process the output issued by the command
		// for instance, this reads the output and writes it to System.out:
		int c;
		while ((c = shellIn.read()) != -1) {
			logger.info("shell read value:"+c);
			}
		// close the stream
			shellIn.close();
			logger.info(" *** End *** "+shellExitStatus);
		logger.info("pb command "+pb.command());
		logger.info("pb command  dir  "+pb.directory());
//		logger.info(pb.environment());
//		logger.info(System.getenv());
//		logger.info(System.getProperties());
		}
		catch (IOException ignoreMe)
		{}
		
	}
	*/
	

}
