package com.yi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.yi.domain.Criteria;
import com.yi.domain.PageMaker;
import com.yi.domain.SboardVO;
import com.yi.domain.SearchCriteria;
import com.yi.service.SboardService;
import com.yi.util.MediaUtils;
import com.yi.util.UploadFileUtils;

@Controller
@RequestMapping("/sboard/*")
public class SboardController {
	private static final Logger logger = LoggerFactory.getLogger(SboardController.class);

	@Resource(name="uploadPath")
	private String uploadPath;
	
	@Autowired
	private SboardService service;
	
	@RequestMapping(value="slist",method=RequestMethod.GET)
	public void slist(SearchCriteria cri, Model model) {
		logger.info("listPage ------- GET");
		List<SboardVO> list = service.listSearch(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.searchTotalCount(cri));
		System.out.println("pageMaker는"+ pageMaker);
		System.out.println("cri는"+cri);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("cri", cri);
	}
	@RequestMapping(value="sregister", method=RequestMethod.GET)
	public void sregistGet() {
		logger.info("sregister ------ get");
	}
	@RequestMapping(value="sregister", method=RequestMethod.POST)
	public String sregisterPost(SboardVO vo, Model model, List<MultipartFile> imageFiles) throws IOException {
		logger.info("sregister ------ post");
		
		List<String> files = new ArrayList<>();
		for(MultipartFile file : imageFiles) {
			logger.info("file name :" + file.getOriginalFilename());
			logger.info("file size :" + file.getSize());
			
			String thumPath = UploadFileUtils.uploadFile(uploadPath, 
														file.getOriginalFilename(), 
														file.getBytes());
			files.add(thumPath);
			
		}
			vo.setFiles(files);
			
			service.insertSboard(vo);
			model.addAttribute("result", "success");
			return "redirect:/sboard/slist";
	}
	@RequestMapping(value="sreadPage", method=RequestMethod.GET)
	public void sreadPage(@RequestParam("sbno") int sbno, Criteria cri, Model model) {
		SboardVO vo = service.readSboard(sbno);
		System.out.println("sbno는"+ sbno);
		System.out.println("vo는"+vo);
		model.addAttribute("SboardVO", vo);
		model.addAttribute("cri", cri);
	}
	@RequestMapping(value="smodifyPage", method=RequestMethod.GET)
	public void smodifyPageGet(@RequestParam("sbno") int sbno, Criteria cri, Model model) {
			SboardVO vo = service.readSboard(sbno);
			model.addAttribute("cri", cri);
			model.addAttribute("SboardVO", vo);			
	}
	@RequestMapping(value="smodifyPage", method=RequestMethod.POST)
	public String smodifyPagePost(SboardVO vo, Criteria cri, Model model, String[] delFiles, List<MultipartFile> addFiles) throws IOException {
		logger.info("smodify ------ post");
		logger.info(vo+"------post");
		if(delFiles != null) {
			for(String delFile : delFiles) {
				logger.info("넌"+delFile);
				
				File file = new File(uploadPath + delFile);
				file.delete();
				
				String front = delFile.substring(0, 12);
				String end = delFile.substring(14);
				String originalFileName = front + end;
				File file2 = new File(uploadPath + originalFileName);
				file2.delete();
			}
		}
				List<String> addImages = new ArrayList<>();
				for(MultipartFile file: addFiles) {
					logger.info("file name :" + file.getOriginalFilename());
					logger.info("file size :" + file.getSize());
					
					if(file.getSize() > 0) {
						String thumb = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
						addImages.add(thumb);
					}
				}
				service.modifyFile(vo, delFiles, addImages);
				System.out.println("vo는"+vo +"delFiles는"+delFiles+ "addimage는" + addImages);
				model.addAttribute("cri", cri);
				return "redirect:/sboard/slist?page=" + cri.getPage();
	}
	@RequestMapping(value="sremovePage", method=RequestMethod.POST)
	public String sremovePage(@RequestParam("sbno") int sbno, Criteria cri, Model model) {
			service.deleteSboard(sbno);
			model.addAttribute("cri",cri);
			return "redirect:/sboard/slist?page=" + cri.getPage();
	}
	
	@ResponseBody
	@RequestMapping("/displayFile")
	public ResponseEntity<byte[]> displayFile(String filename){
		ResponseEntity<byte[]> entity = null;
		logger.info("displayFile : " + filename);
		try {
			String format = filename.substring(filename.lastIndexOf(".") +1);
			MediaType mType = MediaUtils.getMediaType(format);
			
			HttpHeaders headers = new HttpHeaders();
			InputStream in = null;
			in = new FileInputStream(uploadPath+"/"+filename);
			headers.setContentType(mType);
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),
												headers,						
												HttpStatus.CREATED);	
			in.close();					
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
