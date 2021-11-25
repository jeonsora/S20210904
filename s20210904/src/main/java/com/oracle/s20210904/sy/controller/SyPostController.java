package com.oracle.s20210904.sy.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.oracle.s20210904.sy.service.SyPostService;
import com.oracle.s20210904.sy.service.SyPostServiceImpl;
import com.oracle.s20210904.comm.model.Post;

@Controller
public class SyPostController {
	
	@Autowired
	private SyPostService syPostService;
	
	// 게시글 목록
	@RequestMapping(value="/sy/postList.do")
	public ModelAndView postList() throws Exception {
		List<Post> postList = syPostService.postList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sy/postList");
		mav.addObject("postList", postList);
		
		return mav;
	}
	
	// 게시글 작성란
	@RequestMapping(value="/sy/postWriteForm.do", method=RequestMethod.GET)
	public String postWriteForm() throws Exception {
		
		return "sy/postWrite";
	}
	
	// 게시글 작성
	@RequestMapping(value="/sy/postWrite.do", method=RequestMethod.POST)
	public String postWrite(@ModelAttribute Post post) throws Exception {
		
		syPostService.postInsert(post);
		
		return "redirect:postList.do";
	}
	
	// 작성글 조회, 조회수 증가
	@RequestMapping(value="/sy/postView.do", method=RequestMethod.GET)
	public ModelAndView postView(@RequestParam int postCode, HttpSession session) throws Exception {
		
		syPostService.increasePostView(postCode, session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("sy/postView");
		mav.addObject("", syPostService.postRead(postCode));
		
		return mav;
	}
	
	// 게시글 수정
	@RequestMapping(value="/sy/postUpdate.do", method=RequestMethod.POST)
	public String postUpdate(@ModelAttribute Post post) throws Exception {
		
		syPostService.postUpdate(post);
		
		return "redirect:postList.do";
	}
	
	// 게시글 삭제
	@RequestMapping(value="/sy/postDelete.do", method=RequestMethod.POST)
	public String postDelete(@ModelAttribute int postCode) throws Exception {
		
		syPostService.postDelete(postCode);
		
		return "redirect:postList.do";
	}
	
}
