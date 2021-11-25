package com.oracle.s20210904.gm.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.service.Paging;
import com.oracle.s20210904.gm.service.GmAnnoService;

@Controller
public class GmAnnoListController {
	// 공고 List 컨트롤러
	
	private static final Logger logger = LoggerFactory.getLogger(GmAnnoListController.class);
	@Autowired
	private GmAnnoService as;

	/*
	@GetMapping(value="GmAnnoList")
	public String AdminMain() {
		return "gm/GmAnnoList";
	}
	*/
	
	@RequestMapping(value = "GmAnnoList")
	public String GmAnnoList(ComAnnounce comAnnounce, String currentPage, Model model) {
		System.out.println("GmAnnoListController Start List...");
		int total = as.total();
		System.out.println("GmAnnoList total->"+total);
		System.out.println("----------------------------------");
		
		// Paging
		Paging pg = new Paging(total, currentPage);
		comAnnounce.setStart(pg.getStart()); // 1 
		comAnnounce.setEnd(pg.getEnd()); // 5
		
		System.out.println("GmAnnoListController GmAnnoList Start...");
		List<ComAnnounce> listAnno = as.listAnno(comAnnounce); // (Paging이 포함된) Announcr 파라미터 가지고 service 단으로 이동
		
		System.out.println("GmAnnoListController GmAnnoList listAnno.size->"+listAnno.size());
		System.out.println("---------------------------------------------------------------");
		for(ComAnnounce comanno : listAnno) {
			System.out.println("---------GmAnnoList Start -------------");
			System.out.println("comanno.getCom_name()-> "+comanno.getCom_name());
			System.out.println("comanno.getCom_id()->"+comanno.getCom_id());
			System.out.println("comanno.getAnno_code()->"+comanno.getAnno_code());
			System.out.println("comanno.getAnno_title()-> "+comanno.getAnno_title());
			System.out.println("----------GmAnnoList End------------------");
			
		}
		
		model.addAttribute("total", total);
		model.addAttribute("listAnno", listAnno);
		model.addAttribute("pg", pg);
		System.out.println("저장됨");
		
		return "gm/GmAnnoList";
		
	}
	
	@GetMapping(value = "detail")
	public String detail(String anno_code, ComAnnounce com,  Model model) {
		
		System.out.println("com.getJob_tag()->"+com.getJob_tag());
		System.out.println("com.getEmp_type()->"+com.getEmp_type());
		System.out.println("com.getJob_tag()->"+com.getTech_tag1());
		System.out.println("com.getJob_tag()->"+com.getTech_tag2());
		System.out.println("com.getJob_tag()->"+com.getCareer());
		

		System.out.println("GmAnnoListController detail Start...");
		System.out.println("anno_code->"+anno_code);
		ComAnnounce comanno = as.detail(anno_code);
		model.addAttribute("comanno", comanno);
		System.out.println("----------------------------------------");
		System.out.println("comanno.getCom_name()-> "+comanno.getCom_name());
		System.out.println("comanno.getCom_id()->"+comanno.getCom_id());
		System.out.println("comanno.getAnno_code()->"+comanno.getAnno_code());
		System.out.println("comanno.getAnno_title()-> "+comanno.getAnno_title());
		System.out.println("----------------------------------------");
		
		// 공통 테이블에서 값 가져오기
		// 모집 직종 
		System.out.println("GmAnnoListController recjob Start...");
		Comm recjob = as.recjob(com);
		System.out.println("GmAnnoListController recjob.getComm_ctx()->"+recjob.getComm_ctx());
		model.addAttribute("recjob", recjob);
		
		/*
		System.out.println("GmAnnoListController recjob Start...");
		List<Comm> recjob = as.recjob();
		System.out.println("GmAnnoListController recjob.size()->"+recjob.size());
		model.addAttribute("recjob", recjob);
		*/
		
		// 고용형태
		System.out.println("GmAnnoListController emptype Start...");
		Comm emptype = as.emptype();
		System.out.println("GmAnnoListController emptype.getComm_ctx()->"+emptype.getComm_ctx());
		model.addAttribute("emptype", emptype);
		
		
		
		
		
		
		return "gm/GmAnnoDetail";
		
	}
	
	
	
	
	
	
	
	
}
