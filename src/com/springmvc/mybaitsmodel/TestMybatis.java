package com.springmvc.mybaitsmodel;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.springmvc.dao.UserDao;
import com.springmvc.dao.UserDaoImpl;
import com.springmvc.mybatisUtil.MyBatisUtil;


public class TestMybatis extends SqlSessionDaoSupport{
	public User find(){
		UserDao dao =new UserDaoImpl();
		User u =dao.findUserById(6);
		System.out.println(u.getName());
		return u;
	}
	public static void main(String[] args) {
		TestMybatis t=new TestMybatis();
		t.find();
	}
}
