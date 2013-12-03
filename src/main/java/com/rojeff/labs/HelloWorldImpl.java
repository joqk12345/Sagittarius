package com.rojeff.labs;

import javax.jws.WebService;

@WebService(endpointInterface="com.rojeff.labs.HelloWorld")  
public class HelloWorldImpl implements HelloWorld {

	@Override
	public String sayHello(String text) {
			return "hello:"+text ;
	}

	
}
