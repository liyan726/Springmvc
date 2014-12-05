package com.springmvc.testMybatis;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springmvc.mybaitsInterMapper.UserMapper;
import com.springmvc.mybaitsmodel.User;

@RunWith(SpringJUnit4ClassRunner.class) //Ê¹ÓÃSpringtest¿ò¼Ü
@ContextConfiguration("/config/beans.xml")
public class TestMybatisInterMapper {

	@Resource //×¢Èë
	private UserMapper userMapper;
	
	@Test
	public void test() {
		User u = userMapper.selectUserByid(6);
	}

}
