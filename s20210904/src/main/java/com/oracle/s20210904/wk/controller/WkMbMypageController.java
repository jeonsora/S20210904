package com.oracle.s20210904.wk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.comm.model.Apply;
import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.wk.model.Applycount;
import com.oracle.s20210904.wk.service.WkMbMypageService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class WkMbMypageController {
	
	private final WkMbMypageService ms;
	

	private String checkId(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mbid");
		if(id==null || id.equals("")){              
			return "/wk/index";
		}
//		System.out.println("checkId : "+id);
		return id;
	}
	
	@GetMapping(value = "index")
	public String index() {
		return "/wk/index";
	}
	
	@GetMapping(value = "index2")
	public String index2(HttpServletRequest request, Model model) {
		HttpSession session=request.getSession();
		String memberid=(String) request.getParameter("memberid");
		session.setAttribute("mbid", memberid);
//		System.out.println("index : "+memberid);
		return "redirect:mbMypage";
	}
	
	@RequestMapping(value = "mbMypage")
	public String mbMypage(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypage()");
//		HttpSession session = request.getSession();
//		String id=
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
//		System.out.println("WkMbMypageController mbMypage() mbid : "+mbid );
		
		List<Applycount> countapply=ms.countApply(mbid);
		model.addAttribute("countapply", countapply);
		
		List<Resume> resumelist=ms.resumeList(mbid);
		model.addAttribute("resumelist", resumelist);
		
		return "/wk/mbMypage";
	}
	
	
}
