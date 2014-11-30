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
	 * ִ��ʱ������ͼ�Ѿ����������,����try catch ���finally
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
	 * ִ��ʱ����controllerִ���꣬��ͼ������û�а���ͼ������ҳ��,
	 * ����ͼ��ͳһ���޸ģ���Ҫ������Model�� ����jspҳ�涼���Ի�ø�map��testֵ
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView mv) throws Exception {
//		System.out.println("postHandler...");
//		Map<String, Object> map = mv.getModel();
//		map.put("test", "append something");
	}

	/**
	 * ִ��ʱ������ִ��controller֮ǰ��ִ��
	 * ����ֵ���ͣ�boolean��true������п��Է���controller��false�����Է���controller
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
