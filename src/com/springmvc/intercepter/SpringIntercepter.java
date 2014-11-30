package com.springmvc.intercepter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.srpingmvc.entry.MesModel;

public class SpringIntercepter implements HandlerInterceptor {

	/**
	 * 执行时机：视图已经被解析完毕,类似try catch 后的finally
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception ex)
			throws Exception {
		/*System.out.println("afterCompletion...");
		ex.printStackTrace();
		System.out.println("================");*/
	}

	/**
	 * 执行时机：controller执行完，视图解析器没有把视图解析成页面,
	 * 对视图做统一的修改，主要体现在Model上 所有jsp页面都可以获得该map的test值
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView mv) throws Exception {
//		System.out.println("postHandler...");
//		Map<String, Object> map = mv.getModel();
//		map.put("test", "append something");
	}

	/**
	 * 执行时机：在执行controller之前来执行
	 * 返回值类型：boolean：true代表放行可以访问controller，false不可以访问controller
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse rep,
			Object obj) throws Exception {
			
	  String session=(String) req.getSession().getAttribute("name");
		if(session==null||session.equals("")){
			
			MesModel ms= new MesModel();
			ms.setMesName("Login First");
			req.setAttribute("err", ms);
			//rep.sendRedirect("/Springmvc/log.jsp");
			req.getRequestDispatcher("/WEB-INF/jsp/user/log.jsp").forward(req, rep);
		System.out.println("login first");
			return false;
		}
		else 
		return true;
	}

}
