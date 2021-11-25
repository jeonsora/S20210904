package com.oracle.s20210904.sr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.sr.service.SrComMypageService;

public class SrComMypageController {
	//데헷 기업마이페이지 컨트롤러 입니댱~~
	
	@Autowired
	private SrComMypageService scms;
	
	@RequestMapping(value = "CompanyMypage")
	public String CompanyMypage(Company company, Model model) {
		
		System.out.println("SrComMypageController Start list....");
		int total=scms.total();
		System.out.println("SrComMypageController total=>"+total);
		model.addAttribute("total", total);
		return "ComMypage";
	}
	
}
