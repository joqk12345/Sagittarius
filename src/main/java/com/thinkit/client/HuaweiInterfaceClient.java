package com.thinkit.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.thinkit.pojo.AnaParams;
import com.thinkit.pojo.SpeechPojo;
import com.thinkit.webservice.Speech2Text;

class HuaweiInterfaceClient {

	public static void main(String[] args) {
//		ApplicationContext context = new FileSystemXmlApplicationContext("D:\\java\\workspace\\HuaWeiInterface\\target\\HuaWeiInterface-0.0.1-SNAPSHOT\\WEB-INF\\applicationContext.xml"); 
//		  HelloWorld client = (HelloWorld)context.getBean("client");
//        String res = client.sayHello("AAA");
//        System.out.println(res);
		
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(Speech2Text.class);  
        factory.setAddress("http://localhost:8080/HuaweiInterface/huawei");  
        Speech2Text service = (Speech2Text)factory.create();  
       
        String voiceFilePath="";
        String resultFilePath="";
        String grammarFilePath="";
        AnaParams params=null;
        List<SpeechPojo > speechList= new ArrayList<SpeechPojo>();
//  
          service.speech2Text(voiceFilePath, resultFilePath, grammarFilePath, params, speechList);
//        System.out.println("The order ID is " + result); 
		
		
	}

}
