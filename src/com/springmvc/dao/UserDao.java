package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.mybaitsmodel.User;

public interface UserDao {
	User findUserById(int id);
}
