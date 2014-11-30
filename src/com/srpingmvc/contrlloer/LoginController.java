package com.srpingmvc.contrlloer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.dao.UserDao;
import com.springmvc.dao.UserDaoImpl;
import com.springmvc.mybaitsmodel.TestMybatis;
import com.springmvc.mybaitsmodel.User;
import com.srpingmvc.entry.MesModel;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String log(){
		
		return "/user/log";
	}
	
	@RequestMapping(value="/log")
	public String log(String name,Integer id,HttpServletRequest req){

		System.out.println(id);
		UserDao dao =new UserDaoImpl();
		User u =dao.findUserById(id);
		
		if(u!=null){
			req.getSession().setAttribute("name", name);
			return "redirect:/user/users";
			
		}
		
		MesModel ms= new MesModel();
		ms.setMesName("Name is  null");
		req.setAttribute("err", ms);
		
		System.out.println(req.getAttribute("err"));

		return "/user/log";
	}
}
