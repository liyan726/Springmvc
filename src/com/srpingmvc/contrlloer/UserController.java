package com.srpingmvc.contrlloer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.others.DateFactory;
import com.springmvc.others.Encord;
import com.springmvc.others.FileDownLoadUtil;
import com.springmvc.others.FileUploadUtils;
import com.springmvc.others.Jsonutil;
import com.srpingmvc.entry.FilesInfo;
import com.srpingmvc.entry.User;

import org.codehaus.jackson.*;

/**
 * 1、@ModelAttribute定义的方法会在所有的，mapping运行之前进行运行
 * 2、在进行字段校验是要使用@Validated 并且后面紧跟着BindingResult br
 * 3、在进行参数路径设置时 要在所对应的参数上加上@PathVariable
 * 4、json格式加上@ResponseBody
 */
@Controller
@RequestMapping("/user")
public class UserController {

	private static List<User> users;
	static {
		users = DateFactory.userFactory();
	}

	@RequestMapping("/users")
	public String ListUsers(Model model) {
		model.addAttribute("users", users);
		return "/user/users";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add(User user1,User user2,Model mo) {
		user1.setName("1");
		user2.setName("2");
		mo.addAttribute("user1", user1);
		mo.addAttribute("user2", user2);
		
		
		return "/user/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@Validated User user, BindingResult br,@RequestParam("attachs") MultipartFile[] attachs,
			HttpServletRequest req) throws IllegalStateException, IOException {
		if (br.hasErrors()) {
			return "/user/add";
		}

		String realpath = req.getServletContext().getRealPath(
				"resources/upload")+"//";
		for (MultipartFile at : attachs) {
			if (at.isEmpty())
				continue;
			FilesInfo fe = FileUploadUtils.fileupload(at, realpath, req);
		    user.setFile(fe);
			
		}
		users.add(user);
		return "redirect:/user/users";
	}


	@RequestMapping(value = "/dowload/{filename}", method = RequestMethod.GET)
	public ModelAndView download(@PathVariable String filename,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String ctxPath = request.getServletContext().getRealPath(
				"resources/upload")+ "\\";
		String suffx=".doc";
		//FileDownLoadUtil.fileDownload(filename,suffx, ctxPath, request, response);

		return null;
	}

	@RequestMapping(value = "/{name}")
	public String show(@PathVariable String name, User user, Model mo)
			throws UnsupportedEncodingException {
		//name = Encord.Utf8Change(name);
		System.out.println("===="+name);
		for (Iterator<User> it = users.iterator(); it.hasNext();) {
			User u = it.next();
			if (u.getName().equals(name)) {
				user = u;
				break;
			} else
				continue;
		}
		mo.addAttribute(user);
		System.out.println(user.getName());
		return "/user/show";
	}

	@RequestMapping(value = "/json", method = RequestMethod.POST)
	@ResponseBody
	public void showbyjson(String name, User user,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
	System.out.println(name);
		for (Iterator<User> it = users.iterator(); it.hasNext();) {
			User u = it.next();
			if (u.getName().equals(name)) {
				user = u;
				break;
			} else
				continue;
		}
		String res = Jsonutil.beanToJson(user);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(res);
	}

	
}
