package com.rojeff.labs.client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.rojeff.labs.HelloWorld;
public class HelloClient {
	
	
	  public static void main(String[] args) {
		  ApplicationContext context = new FileSystemXmlApplicationContext("D:\\java\\workspace\\HuaWeiInterface\\target\\HuaWeiInterface-0.0.1-SNAPSHOT\\WEB-INF\\applicationContext.xml"); 
		  HelloWorld client = (HelloWorld)context.getBean("client");
          String res = client.sayHello("AAA");
          System.out.println(res);
	  }
	  
	  
}
