package com.oracle.s20210904.wk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.comm.model.Scrap;
import com.oracle.s20210904.wk.service.WkScrapService;


@Controller
public class WkScrapController {
	@Autowired
	private WkScrapService ss;
	
	@RequestMapping(value = "scrapList")
	public String scrapList(Model model) {
		System.out.println("ScrapController scrapList()");
		List<Scrap> listScrap = ss.listScrap();
		model.addAttribute("listScrap", listScrap);
		System.out.println("ScrapController scrapList() listScrap.size : "+listScrap.size());
		return "/wk/scrapList";
	}
}
