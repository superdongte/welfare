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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.yi.controller.MemberController;
import com.yi.domain.UserVO;
import com.yi.service.UserService;
import com.yi.util.MediaUtils;
import com.yi.util.UploadFileUtils;

@Controller
@RequestMapping("/member/*")
public class MemberController {	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static String innerUploadPath = "resources/upload";
	@Autowired
	private UserService service;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value="mRegist", method=RequestMethod.GET)
	public void regUser() {
		logger.info("mRegist ------ GET");
		
	}
	
	@RequestMapping(value="mRegist", method=RequestMethod.POST)
	public String regUser(UserVO vo, Model model, MultipartFile files) throws IOException{
		logger.info("mResist ----- post");
			logger.info("file name:" + files.getOriginalFilename());
			logger.info("file size:" + files.getSize());
			
			String thumPath = UploadFileUtils.uploadFile(uploadPath, 
												files.getOriginalFilename(), 
												files.getBytes());
			
				vo.setPhoto(thumPath);	
		System.out.println(vo);
		service.insertUser(vo);		
		model.addAttribute("result","success");
		return "member/mRegistSuccess";
	}
	
	@ResponseBody
	@RequestMapping(value="/dul", method=RequestMethod.POST)
	public ResponseEntity<String> dulRead(@RequestBody String vo, Model model){
		ResponseEntity<String> entity = null;
		logger.info("member read ---------" + vo);
		
		try {
			boolean dul = service.dulUserid(vo);
			System.out.println("dul은"+ dul);
			System.out.println("vo는" + vo);
			if(dul == true) {
				entity = new ResponseEntity<>("true",HttpStatus.OK);
			}else {
				entity = new ResponseEntity<String>("false", HttpStatus.OK);
			}
			
			System.out.println("entity는"+ entity);
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="mListAll", method=RequestMethod.GET)
	public void listMemberlist(Model model) {
		List<UserVO> list = service.userlistAll();
		System.out.println(list);
		model.addAttribute("list", list);
	}
	@RequestMapping(value="mRead", method=RequestMethod.GET)
	public void read(@RequestParam("userid") String userid, Model model) {
		UserVO uinfo = service.readUser(userid);
		model.addAttribute("userid",uinfo);
	}
	@RequestMapping(value="mUpdate", method=RequestMethod.GET)
	public void updateGet(@RequestParam("userid") String userid, Model model){
		UserVO uinfo = service.readUser(userid);
		model.addAttribute("userid",uinfo);
	}
	@RequestMapping(value="mUpdate", method=RequestMethod.POST)
	public String updatePost(UserVO vo, Model model, MultipartFile files) throws IOException {
		logger.info("file name:" + files.getOriginalFilename());
		logger.info("file size:" + files.getSize());
		
		String thumPath = UploadFileUtils.uploadFile(uploadPath, 
				files.getOriginalFilename(), 
				files.getBytes());

				vo.setPhoto(thumPath);
				service.updateUser(vo);
				model.addAttribute("result","success");
		return "redirect:/member/mRead?userid="+vo.getUserid();
	}
	@RequestMapping(value="mdelete",method=RequestMethod.POST)
	public String delete(@RequestParam("userid") String userid, Model model) {
		service.deleteUser(userid);
		return "redirect:/member/mListAll";
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
