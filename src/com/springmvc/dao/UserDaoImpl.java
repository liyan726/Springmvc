package com.springmvc.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.mybaitsmodel.User;
import com.springmvc.mybatisUtil.MyBatisUtil;

public class UserDaoImpl implements UserDao {
	  @Autowired
	private SqlSession sqlSession;

	@Override
	public User findUserById(int id) {
		
	System.out.println("usering..."+sqlSession);
	User u =new User();
	u.setName("ÀîËÄ");
	u.setAge(88);
	User user = sqlSession.selectOne(User.class.getName()+".selectUserByid", id);
	
	int i = sqlSession.insert(User.class.getName()+".inserUser", u);
	System.out.println(user.getName());
	
		return user;
	}

	 
}
