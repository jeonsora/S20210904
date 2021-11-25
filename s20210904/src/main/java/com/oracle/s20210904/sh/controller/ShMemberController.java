package com.oracle.s20210904.sh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.Member;
import com.oracle.s20210904.sh.service.ShMemberService;

@Controller
public class ShMemberController {

	private static final Logger logger = LoggerFactory.getLogger(ShMemberController.class);
	
	@Autowired
	private ShMemberService ms;
	
	//개인회원가입 
	@RequestMapping (value = "join")
	public String join (Member memebr) {
		System.out.println("ShMemberController join Start...");
		
		return "sh/register";
	}
	
	@RequestMapping(value = "joinSave")
	public String joinSave (Member member, Model model) {
		System.out.println("ShMemberController joinSave Start...");
		int joinmember = ms.joinmember(member);
		//System.out.println("ShMemberController joinmember"+joinmemeber.getUser_id());
		model.addAttribute("joinmember", joinmember);
		
		return "redirect:/";
	}
	
	//기업 회원가입 
	@RequestMapping(value="Comjoin")
	public String join2(Company company) {
		System.out.println("ShUserController join Start...");
			
		return "sh/register2";
	}
	@RequestMapping(value = "ComjoinSave")
	public String joinSave2(Company company, Model model) {
		System.out.println("ShUserController joinSave2 Start...");
	    int joincom = ms.joincom(company);
		model.addAttribute("joincom", joincom);
		return "redirect:/";
		
	}
	
	//로그인 
	
}
