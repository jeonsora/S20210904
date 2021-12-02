package com.oracle.s20210904.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.s20210904.comm.model.Company;
import com.oracle.s20210904.ds.service.DsAdminService;

@RestController
public class DsAdminRestController {
	
	@Autowired
	DsAdminService dsAdminService;
	
	@GetMapping(value="joinConfirm")
	public int joinConfirm(String comId) {
		
		System.out.println("DsAdminRestController Start...");
		int result= dsAdminService.joinConfirm(comId);
		
		return result;
	}
	
	@GetMapping(value="comDetail")
	public Company companyDetail(Company com) {
		Company company = dsAdminService.getCompany(com);
		return company;
	}
}
