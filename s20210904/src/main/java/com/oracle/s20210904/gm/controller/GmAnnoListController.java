package com.oracle.s20210904.gm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oracle.s20210904.comm.model.ComAnnounce;
import com.oracle.s20210904.comm.model.Comm;
import com.oracle.s20210904.comm.model.Resume;
import com.oracle.s20210904.comm.model.Scrap;
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
	public String detail(String anno_code, ComAnnounce com, Model model) {
		
		System.out.println("GmAnnoListController detail Start...");
		System.out.println("anno_code->"+anno_code);
		ComAnnounce comanno = as.detail(anno_code);
		model.addAttribute("comanno", comanno);
		System.out.println("----------------------------------------");
		System.out.println("comanno.getCom_name()-> "+comanno.getCom_name());
		System.out.println("comanno.getCom_id()->"+comanno.getCom_id());
		System.out.println("comanno.getAnno_code()->"+comanno.getAnno_code());
		System.out.println("comanno.getAnno_title()-> "+comanno.getAnno_title());
		System.out.println("comanno.getJob_tag()-> "+comanno.getJob_tag());
		System.out.println("----------------------------------------");
		
		// 공통 테이블에서 값 가져오기
		// 모집 직종 
		
		System.out.println("GmAnnoListController recjob Start...");
		Comm recjob = as.recjob(comanno);
		System.out.println("GmAnnoListController recjob.getComm_ctx()->"+recjob.getComm_ctx());
		model.addAttribute("recjob", recjob);
		System.out.println("------------------------------------");
		
		/*
		System.out.println("GmAnnoListController recjob Start...");
		List<Comm> recjob = as.recjob(com);
		System.out.println("GmAnnoListController recjob.size()->"+recjob.size());
		model.addAttribute("recjob", recjob);
		*/
		
		// 고용형태
		System.out.println("GmAnnoListController emptype Start...");
		Comm emptype = as.emptype(comanno);
		System.out.println("GmAnnoListController emptype.getComm_ctx()->"+emptype.getComm_ctx());
		model.addAttribute("emptype", emptype);
		System.out.println("------------------------------------");
		
		/*
		System.out.println("GmAnnoListController emptype Start...");
		List<Comm> emptype = as.emptype(com);
		System.out.println("GmAnnoListController emptype.getComm_ctx()->"+emptype.size());
		model.addAttribute("emptype", emptype);
		*/
		
		// 기술 스택 1
		System.out.println("GmAnnoListController Techtag1 Start...");
		Comm Techtag1 = as.Techtag1(comanno);
		System.out.println("GmAnnoListController Techtag1.getComm_ctx() "+Techtag1.getComm_ctx());
		model.addAttribute("Techtag1", Techtag1);
		System.out.println("------------------------------------");
		
		// 기술 스택 2
		System.out.println("GmAnnoListController Techtag2 Start...");
		Comm Techtag2 = as.Techtag2(comanno);
		System.out.println("GmAnnoListController Techtag2.getComm_ctx() "+Techtag2.getComm_ctx());
		model.addAttribute("Techtag2", Techtag2);
		System.out.println("------------------------------------");
		
		// 경력
		System.out.println("GmAnnoListController career Start...");
		Comm career = as.career(comanno);
		System.out.println("GmAnnoListController career.getComm_ctx()-> "+career.getComm_ctx());
		model.addAttribute("career", career);
		System.out.println("------------------------------------");
		
		// 업종
		System.out.println("GmAnnoListController comsec Start...");
		Comm comsec = as.comsec(comanno);
		System.out.println("GmAnnoListController comsec.getComm_ctx()->"+comsec.getComm_ctx());
		model.addAttribute("comsec", comsec);
		System.out.println("------------------------------------");
		
		return "gm/GmAnnoDetail";
		
	}
	
	/*
	// 스크랩
		@GetMapping(value = "scrap")
		public String scrap (String anno_code, String user_id) {
			System.out.println("GmAnnoListController scrap Start...");
			Scrap scrap = as.scrap(anno_code, user_id);
			System.out.println("GmAnnoListController scrap.getAnno_code()->"+scrap.getAnno_code());
			
			return "gm/scrap";
			
		}
	*/	
		
		// 스크랩
		@RequestMapping(value = "scrap", produces = "application/text;charset=UTF-8")
		@ResponseBody
		public String scrap (String anno_code, String user_id, int it_like, Model model) {
			System.out.println("GmAnnoListController scrap Start...");
//			Scrap scrap = new Scrap();
//			scrap.setAnno_code(anno_code);
//			scrap.setUser_id(user_id);
			System.out.println("------------------------------------");
			
			System.out.println("GmAnnoListController scrap anno_code->"+anno_code);
			System.out.println("GmAnnoListController scrap user_id->"+user_id);
			System.out.println("GmAnnoListController scrap it_like->"+it_like);
			
			/*
			 * int itlike = 0; int check = as.likecnt(scrap);
			 * System.out.println("Controller check ->" + check);
			 * 
			 * if (check == 0) { as.likeinsert(scrap); } else if (check == 1) { itlike =
			 * as.likegetinfo(scrap); System.out.println("insert 안되었어~"); }
			 * 
			 * model.addAttribute("itlike", itlike);
			 */
			return "1";

		 }
		
	
		
		
	
		
		@PostMapping (value = "likeupdate")
		@ResponseBody
		public Map<String, String> likeupdate (Scrap scrap){
			logger.info("likeupdate");
			
			Map<String, String> map = new HashMap<String, String>();
			
			try {
				as.likeupdate(scrap);
				map.put("result", "success");
			} catch (Exception e) {
				System.out.println("GmAnnoListController likeupdate Exception "+e.getMessage());
				map.put("result", "fail");
			}
			
			return map;
			
		}
	
		@RequestMapping(value = "GmApplyList")
		public String apply(Resume resume, String currentPage, Model model) {
			System.out.println("GmAnnoListController apply Start List...");
			int tot = as.applytotal();
			System.out.println("applyList tot->"+tot);
			System.out.println("----------------------------------");
			
			// Paging
			Paging pg = new Paging(tot, currentPage);
			resume.setStart(pg.getStart()); // 1 
			resume.setEnd(pg.getEnd()); // 5
			
			System.out.println("GmAnnoListController applyList Start...");
			String user_id = "";
			List<Resume> listres = as.listres(resume); 
			
			System.out.println("GmAnnoListController applyList listres.size->"+listres.size());
			System.out.println("---------------------------------------------------------------");
			for(Resume res : listres) {
				System.out.println("---------applyList Start -------------");
				System.out.println("res.getUser_id()->"+res.getUser_id());
				System.out.println("res.getRes_title()-> "+res.getRes_title());
				System.out.println("res.getRes_date()->"+res.getRes_date());
				System.out.println("----------applyList End------------------");
				
			}
			
			model.addAttribute("tot", tot);
			model.addAttribute("listres", listres);
			model.addAttribute("pg", pg);
			
			return "gm/GmApplyList";
			
		}
		
		
		// 지원하기
		@RequestMapping(value = "applychk", produces = "application/text;charset=UTF-8")
		@ResponseBody
		public String applychk (String user_id, int res_code) {
			System.out.println("GmAnnoListController applychk Start...");
			
			System.out.println("GmAnnoListController applychk user_id->"+user_id);
			System.out.println("GmAnnoListController applychk res_code->"+res_code);
			
			Resume resume = new Resume();
			resume.setUser_id(user_id);
			resume.setRes_code(res_code);
			
			resume = as.selResume(resume);
			System.out.println("Controller resume.getUser_id()->"+resume.getUser_id());
			System.out.println("Controller resume.getRes_code()->"+resume.getRes_code());
			
			
			
			return "1";

		 }
	
	
	
	
	
}
