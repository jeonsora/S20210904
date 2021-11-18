package com.oracle.sBootMybatis03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.sBootMybatis03.domain.Member;
import com.oracle.sBootMybatis03.service.MemberJpaService;


@Controller
public class MemberJpaController {
	private final MemberJpaService memberJpaService;
	@Autowired
	public MemberJpaController(MemberJpaService memberJpaService) {
		super();
		this.memberJpaService = memberJpaService;
	}
	
	@GetMapping(value = "/members")
	public String listMember(Model model) {
		System.out.println("EmpController listMember()");
		List<Member> memberList=memberJpaService.getListAllMember();
		model.addAttribute("members", memberList);
	
		return "memberList";
	}
	
	
	
}
