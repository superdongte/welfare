package com.yi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yi.controller.MemberController;
import com.yi.domain.UserVO;
import com.yi.service.UserService;

@RestController
@RequestMapping("/member/*")
public class MemberController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="mRegist", method=RequestMethod.GET)
	public void regUser() {
		logger.info("get--------");
	}
	@RequestMapping(value="mRegist", method=RequestMethod.POST)
	public ResponseEntity<String> regUser( @RequestBody UserVO vo){
		ResponseEntity<String> entity = null;
		logger.info("User insert ---------" + vo);
		try {
			service.insertUser(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> dulRead(@RequestBody UserVO vo){
		ResponseEntity<String> entity = null;
		logger.info("member read ---------" + vo);
		
		try {
			service.dulUserid(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
