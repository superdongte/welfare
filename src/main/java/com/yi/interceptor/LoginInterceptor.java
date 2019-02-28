package com.yi.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yi.controller.HomeController;
import com.yi.domain.LoginDTO;

public class LoginInterceptor implements HandlerInterceptor {
	
	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("----------- login preHandler");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("----------- login postHandle");
		
		LoginDTO vo = (LoginDTO)modelAndView.getModel().get("loginDTO");
		System.out.println("로그 vo는"+vo);
		if(vo != null) {//회원이 로그인 시도
			HttpSession session = request.getSession();
			session.setAttribute(LOGIN, vo);
			System.out.println("로그안에 vo는"+vo);
			Object dest = session.getAttribute("dest");
			String path = dest != null ? (String)dest : request.getContextPath();
			System.out.println("path는"+path);
			
			response.sendRedirect(path);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("----------- login afterCompletion");
	}

}
