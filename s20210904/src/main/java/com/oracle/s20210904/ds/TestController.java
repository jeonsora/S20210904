package com.oracle.s20210904.ds;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping(value="testForm")
	public String testForm() {
		return "testForm";
	}
	
	@GetMapping(value="AdminMain")
	public String AdminMain() {
		return "AdminMain";
	}
	
	@GetMapping(value="header")
	public String header() {
		return "header";
	}
	
	@GetMapping(value="test")
	public String test(String id,Model model) {
		String id2 = id;
		model.addAttribute("id",id2);
		return "test";
	}
}
