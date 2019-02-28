package com.yi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yi.domain.SupportVO;
import com.yi.service.SupportService;

@Controller
@RequestMapping("/sup/*")
public class SupportController {
	private static final Logger logger = LoggerFactory.getLogger(SupportController.class);

	@Autowired

	private SupportService service;
	
	@RequestMapping(value="donation", method=RequestMethod.GET)
	public void regdonaGET() {
		logger.info("donation ----- GET");
	}
	@RequestMapping(value="donation", method=RequestMethod.POST)
	public String regdonaPost(SupportVO vo, Model model) {
		logger.info("donation ------ Post");
		
		service.insertMoney(vo);
		System.out.println();
		model.addAttribute("result", "success");
		return "/sup/donationSuccess";
	}
	
	@RequestMapping(value="sVol",method=RequestMethod.GET)
	public void listAllSvol(Model model) {
		List<SupportVO> list = service.SupportVol();
		System.out.println(list);
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value="sMoney",method=RequestMethod.GET)
	public void listAllsMoney(Model model) {
		List<SupportVO> list = service.SupportMoney();
		model.addAttribute("list",list);
	}
	
	
	
}
