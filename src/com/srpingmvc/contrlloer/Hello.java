package com.srpingmvc.contrlloer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.srpingmvc.entry.User;

@Controller
public class Hello {

	@RequestMapping({ "/hello", "/" })
	public String hello(User u, Model moel) {

		
		moel.addAttribute("user", u);
		System.out.println(u.getId());
		System.out.println(u.getName());
		for (Integer name : u.getCards()) {
			System.out.println(name);
		}

		return "hello";
	}
}
