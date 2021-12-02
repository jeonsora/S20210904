package com.oracle.s20210904.wk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.service.WkMbMypageService;

@RestController
public class WkMbMypageRestController {

	private final WkMbMypageService ms;
	@Autowired
	public WkMbMypageRestController(WkMbMypageService ms) {
		super();
		this.ms = ms;
	}
	
	private String checkId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mbid");
		if(id==null || id.equals("")){              
			return "/wk/wkindex";
		}
		return id;
	}
	
	
	
	
	@RequestMapping(value = "mbMypageResumeDelete", produces = "application/text;charset=UTF-8")
	public String mbMypageResumeDelete(HttpServletRequest request, int res_code) {
		System.out.println("WkMbMypageRestController mbMypageResumeDelete()");
		String mbid=checkId(request);
//		model.addAttribute("mbid", mbid);
		Resume resume=new Resume();
		resume.setUser_id(mbid);
		resume.setRes_code(res_code);
		
		System.out.println("test mbid, res_code : "+mbid+" : "+res_code);
		int result=ms.resumeDelete(resume);
		
		return Integer.toString(result); 
	}
	
}
