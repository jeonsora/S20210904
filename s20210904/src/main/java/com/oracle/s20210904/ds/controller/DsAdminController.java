package com.oracle.s20210904.ds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.oracle.s20210904.ds.service.DsAdminService;

@Controller
public class DsAdminController {
	
	@Autowired
	DsAdminService dsAdminService;
	
	@GetMapping(value="AdminMain")
	public String AdminMain() {
		return "ds/AdminMain";
	}

}
