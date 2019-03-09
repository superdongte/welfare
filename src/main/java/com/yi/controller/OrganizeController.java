package com.yi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yi.domain.OrganizeVO;
import com.yi.domain.VolunteerVO;
import com.yi.service.OrganizeService;

@Controller
@RequestMapping("/organ/*")
public class OrganizeController {
	private static final Logger logger = LoggerFactory.getLogger(OrganizeController.class);
	
	@Autowired
	private OrganizeService service;
	
	@RequestMapping(value="OranizeRead",method=RequestMethod.GET)
	public void readOrgan() {
		logger.info("OranzeRead ------- get");
	}
	@ResponseBody
	@RequestMapping(value="All", method=RequestMethod.GET)
	public ResponseEntity<List<OrganizeVO>> olist(){
		ResponseEntity<List<OrganizeVO>> entity = null;
		
		try {
			List<OrganizeVO> list = service.selectAllOranize();
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@ResponseBody
	@RequestMapping(value="insertOrgan", method=RequestMethod.POST)
	public ResponseEntity<String> insertOrgan(@RequestBody OrganizeVO vo){
		ResponseEntity<String> entity = null;
		logger.info("insert Vol ---------");
		
		try {
			service.insertOrganize(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@ResponseBody
	@RequestMapping(value = "{ornum}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateOr(@PathVariable("ornum") int ornum, @RequestBody OrganizeVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setOrnum(ornum);
			service.updateOrganize(vo);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@ResponseBody
	@RequestMapping(value = "{ornum}", method = RequestMethod.DELETE)
	public ResponseEntity<String> removeOr(@PathVariable("ornum") int ornum){
		ResponseEntity<String> entity = null;
		try {
			service.deleteOraganize(ornum);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
