package com.springmvc.dao;

import com.springmvc.mybaitsmodel.User;

public interface UserDao {
	User findUserById(int id);
}
