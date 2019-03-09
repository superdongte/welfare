package com.yi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yi.domain.Criteria;
import com.yi.domain.FboardVO;
import com.yi.domain.PageMaker;
import com.yi.domain.SearchCriteria;
import com.yi.service.FboardService;

@Controller
@RequestMapping("/fboard/*")
public class FboardController {
	private static final Logger logger = LoggerFactory.getLogger(FboardController.class);
	
	@Autowired
	private FboardService service;
	
	@RequestMapping(value="flist", method=RequestMethod.GET)
	public void flist(SearchCriteria cri, Model model) {
		logger.info("flistPage ----- GET");
		List<FboardVO> list = service.listSearch(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		System.out.println("pageMaker는" + pageMaker);
		System.out.println("cri는"+ cri);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);
	}
	@RequestMapping(value="fregister",method=RequestMethod.GET)
	public void fregistGet() {
		logger.info("register ----- get");
	}
	@RequestMapping(value="fregister",method=RequestMethod.POST)
	public String fresgistPost(FboardVO vo, Model model) {
		logger.info("register ----- post");
	
		service.insertFboard(vo);
		model.addAttribute("result", "success");
		return "redirect:/fboard/flist";
	}
	@RequestMapping(value="freadPage", method=RequestMethod.GET)
	public void freadPage(@RequestParam("fbno") int fbno, Criteria cri, Model model) {
		FboardVO vo = service.readFboard(fbno);
		model.addAttribute("FboardVO",vo);
		model.addAttribute("cri", cri);
	}
	@RequestMapping(value="fmodifyPage", method=RequestMethod.GET)
	public void fmodifyGet(@RequestParam("fbno") int fbno, Criteria cri, Model model) {
		FboardVO vo = service.readFboard(fbno);
		model.addAttribute("FboardVO", vo);
		model.addAttribute("cri", cri);
	}
	@RequestMapping(value="fmodifyPage", method=RequestMethod.POST)
	public String fmodifyPost(FboardVO vo, Criteria cri, Model model) {
		service.updateFboard(vo);
		model.addAttribute("cri",cri);
		return "redirect:/fboard/flist?page=" + cri.getPage();
	}
	@RequestMapping(value="fremovePage", method=RequestMethod.POST)
	public String fremovePage(@RequestParam("fbno") int frno, Criteria cri, Model model) {
		service.deleteFboard(frno);
		model.addAttribute("cri", cri);
		return "redirect:/fboard/flist?page=" + cri.getPage();
	}
}
