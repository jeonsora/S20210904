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
import com.oracle.s20210904.wk.model.WkApply;
import com.oracle.s20210904.wk.model.WkApplyCount;
import com.oracle.s20210904.wk.model.WkResume;
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
			return "/wk/wkindex";
		}
//		System.out.println("checkId : "+id);
		return id;
	}
	
	@GetMapping(value = "wkindex")
	public String index() {
		return "/wk/wkindex";
	}
	
	@GetMapping(value = "wkindex2")
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
		
		List<WkApplyCount> countapply=ms.countApply(mbid);
		model.addAttribute("countapply", countapply);
		
		List<WkResume> resumelist=ms.resumeList(mbid);
		model.addAttribute("resumelist", resumelist);
		
		return "/wk/mbMypage";
	}
	
	@GetMapping(value = "mbMypageApply")
	public String mbMypageApply(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageApply()");
		String mbid=checkId(request);
		
		List<WkApplyCount> countapply=ms.countApply(mbid);
		model.addAttribute("countapply", countapply);
		
		List<WkApply> applyList=ms.applyList(mbid);
		model.addAttribute("applyList", applyList);
		
		return "/wk/mbMypageApply";
	}
	
	@RequestMapping(value = "mbMypageResume")
	public String mbMypageResume(HttpServletRequest request, Model model) {
		System.out.println("WkMbMypageController mbMypageResume()");
		String mbid=checkId(request);
		model.addAttribute("mbid", mbid);
		
		List<WkResume> resumelist=ms.resumeList(mbid);
		model.addAttribute("resumelist", resumelist);
		
		return "/wk/mbMypageResume";
	}
	
	
}
