package com.yi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yi.domain.VolunteerVO;
import com.yi.service.VolunteerService;

@Controller
@RequestMapping("/vol/*")
public class VolunteerController {
	private static final Logger logger = LoggerFactory.getLogger(VolunteerController.class);

	@Autowired
	private VolunteerService service;
	
	@RequestMapping(value="VolunteerRead", method=RequestMethod.GET)
	public void readVol() {
		logger.info("volunteer ---- GET");
	}
	
	@ResponseBody
	@RequestMapping(value="All", method=RequestMethod.GET)
	public ResponseEntity<List<VolunteerVO>> vlist(){
		ResponseEntity<List<VolunteerVO>> entity = null;
		
		try {
			List<VolunteerVO> list = service.listAllVol();
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value="insertVol", method=RequestMethod.POST)
	public ResponseEntity<String> insertvol(@RequestBody VolunteerVO vo){
		ResponseEntity<String> entity = null;
		logger.info("insert Vol ---------");
		
		try {
			service.insertVol(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@ResponseBody
	@RequestMapping(value = "{vnumber}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@PathVariable("vnumber") int vnumber, @RequestBody VolunteerVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setVnumber(vnumber);
			service.updateVol(vo);
			entity = new ResponseEntity<String>("success",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping(value = "{vnumber}", method = RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("vnumber") int vnumber){
		ResponseEntity<String> entity = null;
		try {
			service.deleteVol(vnumber);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
