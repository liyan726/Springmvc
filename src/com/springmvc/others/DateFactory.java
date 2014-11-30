package com.springmvc.others;

import java.util.ArrayList;
import java.util.List;

import com.srpingmvc.entry.User;

public class DateFactory {
	
    public static List<User> userFactory(){
    	
    	List<User> users = new ArrayList<User>();
    	User user = new User();
		user.setId(1);
		user.setName("李四");
		List lis = new ArrayList<Integer>();
		lis.add(1);
		lis.add(2);
		user.setCards(lis);

		User user2 = new User();
		user2.setId(2);
		user2.setName("张三");
		List lis2 = new ArrayList<Integer>();
		lis2.add(1);
		lis2.add(2);
		user2.setCards(lis2);

		User user3 = new User();
		user3.setId(3);
		user3.setName("王五");
		List lis3 = new ArrayList<Integer>();
		lis3.add(1);
		lis3.add(2);
		user3.setCards(lis3);

		users.add(user);
		users.add(user2);
		users.add(user3);
		
		return users;
    }
}
