package com.oracle.s20210904.sy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.sy.service.SyPostService;
import com.oracle.s20210904.sy.service.SyPostServiceImpl;
import com.oracle.s20210904.comm.model.Post;

@Controller
public class SyPostController {
	
	@Autowired
	private SyPostService syPostService;
	
	@RequestMapping(value="/sy/postList.do")
	public String Post(@ModelAttribute("post") Post post, Model model) throws Exception {
		
		// list 전체적으로 추가
		// 언더바로 해야 하던가? 다른 사람들 거 살펴보기
		
		return "sy/postList";
	}
	
	@RequestMapping(value="/sy/postWriteForm.do")
	public String postWriteForm() throws Exception {
		
		return "sy/postWrite";
	}
	
	@RequestMapping(value="/sy/postWrite.do")
	public String postWrite(@ModelAttribute("post") Post post, Model model) throws Exception {
		
		syPostService.postInsert(post);
		
		return "sy/postWrite";
	}
	
	@RequestMapping(value="/sy/postView.do")
	public String postView(@ModelAttribute("post") Post post, Model model, HttpServletRequest request) throws Exception {
		
		int postCode = Integer.parseInt(request.getParameter("postCode"));
		post.setPost_code(post_code);
		
		post postResult = SyPostServiceImpl.selectPostByCode(post);
		
		model.addAttribute("postResult", postResult);
		
		return "sy/postView";
	}
	
}
