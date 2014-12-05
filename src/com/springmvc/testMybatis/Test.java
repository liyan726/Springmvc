package com.springmvc.testMybatis;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmvc.dao.UserDao;
import com.springmvc.mybaitsmodel.User;

public class Test {

@Autowired
	public static void main(String[] args) {
		//
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/config/beans.xml");
	UserDao service = (UserDao) ctx.getBean("dao");

		
		
		User u = service.findUserById(6);

		System.out.println(u.getName());
	}

}
