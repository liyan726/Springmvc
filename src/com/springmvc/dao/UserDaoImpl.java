package com.springmvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.springmvc.mybaitsmodel.User;
import com.springmvc.mybatisUtil.MyBatisUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public User findUserById(int id) {
		SqlSession session = MyBatisUtil.createSession();
		User user= null;
		try {
			user = session.selectOne(User.class.getName()+".selectUserByid", id);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		session.close();
		return user;
	}

	 
}
