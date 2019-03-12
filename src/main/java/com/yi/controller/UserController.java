package com.yi.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.LoginDTO;
import com.yi.domain.UserVO;
import com.yi.service.UserService;

@Controller
@RequestMapping("/user/*")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void loginGet() {
		logger.info("login GET------");
	}
	@RequestMapping(value="loginPost", method=RequestMethod.POST)
	public void loginPost(String userid, String userpw, Model model, boolean admin) {
		logger.info("login POST ----------------"); 
		UserVO vo = service.read(userid, userpw);
		System.out.println("vo는"+vo);
		if(vo == null) {
			logger.info("loginPOST return....");
			return;
		}
		LoginDTO dto = new LoginDTO();
		dto.setUserid(vo.getUserid());
		dto.setUsername(vo.getUsername());
		dto.setAdmin(vo.isAdmin());
		model.addAttribute("loginDTO", dto);
		System.out.println("dto는"+dto);
		//"loginDTO" 값이 logininterceptor에 감
	}
	@RequestMapping(value="logout",method=RequestMethod.GET)
	public String logOutGET(HttpSession session) {
		logger.info("logout GET ---------");
		session.invalidate();
		
		return "redirect:/";
	}
}
