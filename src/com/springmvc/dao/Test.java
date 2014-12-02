package com.springmvc.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/config/beans.xml");
	UserDaoImpl service = (UserDaoImpl)ctx.getBean("userDaoimpl");


	service.findUserById(6);
	}

}
