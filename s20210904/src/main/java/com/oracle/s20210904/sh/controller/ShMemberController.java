package com.oracle.s20210904.sh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.comm.model.User;
import com.oracle.s20210904.sh.service.ShMemberService;

@Controller
public class ShMemberController {

	private static final Logger logger = LoggerFactory.getLogger(ShMemberController.class);
	
	@Autowired
	private ShMemberService us;
	
	//개인회원가입 
	@RequestMapping (value = "join")
	public String join (User user) {
		System.out.println("ShUserController join Start...");
		
		return "sh/register";
	}
	
	@RequestMapping(value = "joinSave")
	public String joinSave (User user, Model model) {
		System.out.println("ShUserController joinSave Start...");
		int joinuser = us.joinuser(user);
		//System.out.println("ShUserController joinuser"+joinuser.getUser_id());
		model.addAttribute("joinuser", joinuser);
		
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
	    int joincom = us.joincom(company);
		model.addAttribute("joincom", joincom);
		return "redirect:/";
		
	}
	
	//로그인 
	
}
