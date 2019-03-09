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
import com.yi.domain.JboardVO;
import com.yi.domain.OrganizeVO;
import com.yi.domain.PageMaker;
import com.yi.domain.SearchCriteria;
import com.yi.service.JboardService;
import com.yi.service.OrganizeService;

@Controller
@RequestMapping("/jboard/*")
public class JboardController {
	private static final Logger logger = LoggerFactory.getLogger(JboardController.class);
	
	@Autowired
	private JboardService service;
	
	@Autowired
	private OrganizeService oservice;
	
	@RequestMapping(value="jlist", method=RequestMethod.GET)
	public void jlist(SearchCriteria cri, Model model) {
		logger.info("jlist ------ GET");
		List<JboardVO> list = service.listSearch(cri);
		System.out.println("list는"+ list);
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		System.out.println("pageMaker는" + pageMaker);
		System.out.println("cri는"+ cri);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);		
	}
	
	@RequestMapping(value="jregister",method=RequestMethod.GET)
	public void jregistGet(Model model) {
		logger.info("jregister ------- get");
		List<OrganizeVO> list = oservice.selectAllOranize();
		model.addAttribute("list", list);
	}
	@RequestMapping(value="jregister", method=RequestMethod.POST)
	public String jregistPost(JboardVO vo, Model model) {
		logger.info("jregister ------- post");
		service.insertJboard(vo);
		model.addAttribute("result", "success");
		return "redirect:/jboard/jlist";
	}
	@RequestMapping(value="jreadPage", method=RequestMethod.GET)
	public void freadPage(@RequestParam("jbno") int jbno, Criteria cri, Model model) {
		JboardVO vo = service.readJboard(jbno);
		model.addAttribute("JboardVO",vo);
		model.addAttribute("cri", cri);
	}
	@RequestMapping(value="jmodifyPage", method=RequestMethod.GET)
	public void fmodifyGet(@RequestParam("jbno") int jbno, Criteria cri, Model model) {
		logger.info("jmodifyPage ------ GET");
		JboardVO vo = service.readJboard(jbno);
		model.addAttribute("JboardVO", vo);
		model.addAttribute("cri", cri);
	}
	@RequestMapping(value="jmodifyPage", method=RequestMethod.POST)
	public String fmodifyPost(JboardVO vo, Criteria cri, Model model) {
		service.updateJboard(vo);
		model.addAttribute("cri",cri);
		return "redirect:/jboard/jlist?page=" + cri.getPage();
	}
	@RequestMapping(value="jremovePage", method=RequestMethod.POST)
	public String fremovePage(@RequestParam("jbno") int jbno, Criteria cri, Model model) {
		service.deleteJboard(jbno);
		model.addAttribute("cri", cri);
		return "redirect:/jboard/jlist?page=" + cri.getPage();
	}
}
