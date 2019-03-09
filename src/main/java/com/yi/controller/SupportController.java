package com.yi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yi.domain.PageMaker;
import com.yi.domain.SearchCriteria;
import com.yi.domain.SupportVO;
import com.yi.domain.VolunteerVO;
import com.yi.service.SupportService;
import com.yi.service.VolunteerService;

@Controller
@RequestMapping("/sup/*")
public class SupportController {
	private static final Logger logger = LoggerFactory.getLogger(SupportController.class);

	@Autowired
	private SupportService service;
	
	@Autowired
	private VolunteerService volservice;
	
	@RequestMapping(value="Volservice", method=RequestMethod.GET)
	public void regVolservice(Model model) {
		logger.info("Volservice ----- GET");
		List<VolunteerVO> list = volservice.listAllVol();
		model.addAttribute("list", list);
	}
	@RequestMapping(value="Volservice", method=RequestMethod.POST)
	public String regVolserviceget(SupportVO vo, Model model) {
		logger.info("Volservice ----- Post");
		
		service.insertVolunteer(vo);
		model.addAttribute("result","success");
		return "/sup/volserviceSuccess";
	}
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
	public void listAllSvol(Model model, SearchCriteria cri) {
		List<SupportVO> list = service.listSearch(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		model.addAttribute("list", list);
		model.addAttribute("cri", cri);
		model.addAttribute("pageMaker", pageMaker);
		System.out.println("pageMaker는"+ pageMaker);
		System.out.println("크리는" + cri);
	}
	
	@RequestMapping(value="sMoney",method=RequestMethod.GET)
	public void listAllsMoney(Model model, SearchCriteria cri) {
		
		List<SupportVO> list = service.listMoney(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		
		model.addAttribute("list", list);
		model.addAttribute("cri", cri);
		model.addAttribute("pageMaker", pageMaker);
	}
	
	
}
