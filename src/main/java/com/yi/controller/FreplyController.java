package com.yi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yi.domain.Criteria;
import com.yi.domain.FboardVO;
import com.yi.domain.FreplyVO;
import com.yi.domain.PageMaker;
import com.yi.service.FboardService;
import com.yi.service.FreplyService;

@RestController
@RequestMapping("/freplies/*")
public class FreplyController {
	private static final Logger logger = LoggerFactory.getLogger(FreplyController.class);
	
	@Autowired
	private FreplyService service;
	
	@Autowired
	private FboardService fservice;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> freplyinsert(@RequestBody FreplyVO vo){
		ResponseEntity<String> entity = null;
		logger.info("freply insert ------" + vo);
			
		try {
			service.insertFreply(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/all/{fbno}", method=RequestMethod.GET)
	public ResponseEntity<List<FreplyVO>> list(@PathVariable("fbno") int fbno){
		ResponseEntity<List<FreplyVO>> entity = null;
		
		try {
			List<FreplyVO> list = service.listAllFreply(fbno);
			entity = new ResponseEntity<>(list, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/{fbno}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("fbno") int fbno, @PathVariable("page") int page){
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			Criteria cri = new Criteria();
			cri.setPage(page);
			
			List<FreplyVO> list = service.listPage(cri, fbno);
			FboardVO vo = fservice.readFboard(fbno);
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			
			int count = service.totalCount(fbno);
			pageMaker.setTotalCount(count);
			
			HashMap<String, Object> map = new HashMap<>();
			map.put("list", list);
			map.put("pageMaker", pageMaker);
			map.put("freplycnt", vo.getFreplycnt());
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="{frno}",method=RequestMethod.PUT)
	public ResponseEntity<String> freplyupdate(@PathVariable("frno") int frno, @RequestBody FreplyVO vo){
		ResponseEntity<String> entity = null;
		logger.info("vo는"+ vo);
		try {
			vo.setFrno(frno);
			service.updateFreply(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="{frno}", method=RequestMethod.DELETE)
	public ResponseEntity<String> freplyremove(@PathVariable("frno") int frno){
		ResponseEntity<String> entity = null;
		
		try {
			service.deleteFreply(frno);
			entity = new ResponseEntity<>("success", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
